package kr.co.fastcampus.eatgo.application;

import kr.co.fastcampus.eatgo.domain.User;
import kr.co.fastcampus.eatgo.domain.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;

public class UserServiceTests {

    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @Before
    public void  setUp(){
        MockitoAnnotations.initMocks(this);
    }
    @Test
    public void getUser(){
     List<User> mockUser = new ArrayList<>();
     mockUser.add(User.builder()
             .email("test@example.com")
             .name("테스터")
             .level(1L)
             .build());

     given(userRepository.findALl()).willReturn(mockUser);

     List<User> users = userService.getUsers();

     User user = users.get(0);

     assertThat(user.getName(), is("테스터"));

    }


    @Test
    public void addUser(){
        String email = "admin@exmaple.com";
        String name = "Administrator";

        User mockUser = User.builder().email(email).name(name).build();

        given(userRepository.save(any())).willReturn(mockUser);

        User user = userService.addUser(email, name);

        assertThat(user.getName(), is(name));
    }

    //TODO update & deactiveUser
}