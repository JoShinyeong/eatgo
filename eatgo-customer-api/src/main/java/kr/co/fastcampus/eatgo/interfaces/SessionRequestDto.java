package kr.co.fastcampus.eatgo.interfaces;


import lombok.Builder;
import lombok.Data;

@Data

public class SessionRequestDto {

    private  String email;

    private  String password;

}
