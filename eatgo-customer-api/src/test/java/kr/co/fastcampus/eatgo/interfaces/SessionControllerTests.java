package kr.co.fastcampus.eatgo.interfaces;

import kr.co.fastcampus.eatgo.application.EmailNotExistedException;
import kr.co.fastcampus.eatgo.application.PasswordWrongException;
import kr.co.fastcampus.eatgo.application.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringRunner.class)
@WebMvcTest(SessionController.class)
public class SessionControllerTests {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private UserService userService;


    @Test
    public void createWithValidAttributes() throws Exception {

        mvc.perform(post("/session")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"email\":\"tester@exmaple.com\",\"password\":\"test\"}"))
                .andExpect(status().isCreated())
                .andExpect(header().string("location", "/session"))
                .andExpect(content().string("{\"accessToken\":\"ACCESSTOKEN\"}"));

        verify(userService).autthenticate(eq("tester@exmaple.com"), eq("test"));

    }

    @Test
    public void createWithNotExistedEmail() throws Exception {

        given(userService.autthenticate("x@exmaple.com", "test"))
                .willThrow(EmailNotExistedException.class);

        mvc.perform(post("/session")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"email\":\"x@exmaple.com\",\"password\":\"test\"}"))
                .andExpect(status().isBadRequest());

        verify(userService).autthenticate(eq("x@exmaple.com"), eq("test"));

    }

    @Test
    public void createWithWrongPassword() throws Exception {

        given(userService.autthenticate("tester@exmaple.com", "testtest"))
                .willThrow(PasswordWrongException.class);

        mvc.perform(post("/session")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"email\":\"tester@exmaple.com\",\"password\":\"testtest\"}"))
                .andExpect(status().isBadRequest());

        verify(userService).autthenticate(eq("tester@exmaple.com"), eq("testtest"));

    }

}
