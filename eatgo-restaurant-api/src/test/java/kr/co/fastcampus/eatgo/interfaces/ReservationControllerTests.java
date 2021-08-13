package kr.co.fastcampus.eatgo.interfaces;

import kr.co.fastcampus.eatgo.application.ReservationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ReservationController.class)
public class ReservationControllerTests {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private ReservationService reservationService;

    @Test
    public void list() throws Exception {
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJ1c2VySWQiOjIsIm5hbWUiOiLqsIDqsowg7KO87J24IiwicmVzdGF1cmFudElkIjoxfQ.YMR6Dhg0C8cGVop98wMFRtgOdvsYclIQZQlvPpMwcOQ";

        mvc.perform(get("/reservations")
                .header("Authorization", "Bearer " + token))
                .andExpect(status().isOk());

        verify(reservationService).getReservations(1L);
    }

}

//"Authorization:Bearer eyJhbGciOiJIUzI1NiJ9.eyJ1c2VySWQiOjIsIm5hbWUiOiLqsIDqsowg7KO87J24IiwicmVzdGF1cmFudElkIjoxfQ.YMR6Dhg0C8cGVop98wMFRtgOdvsYclIQZQlvPpMwcOQ"