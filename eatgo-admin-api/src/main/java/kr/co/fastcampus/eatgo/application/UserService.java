package kr.co.fastcampus.eatgo.application;

import kr.co.fastcampus.eatgo.domain.User;
import kr.co.fastcampus.eatgo.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository=userRepository;

    }

    public List<User> getUsers(){
        List<User> users = userRepository.findALl();

        return users;
    }

    public User addUser(String email, String name){
        User user = User.builder()
                .email(email)
                .name(name)
                .level(1L)
                .build();

        return userRepository.save(user);
    }


    //TODO : update&deactive
}