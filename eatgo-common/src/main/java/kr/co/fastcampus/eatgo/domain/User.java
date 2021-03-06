package kr.co.fastcampus.eatgo.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Getter
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @Setter
    @NotEmpty
    private String email;

    @Setter
    @NotEmpty
    private String name;

    @Setter
    @NotNull
    private Long level;

    private String password;

    private Long restaurantId;

    public boolean isAdmin() {
        return level >= 100;
    }

    public boolean isActive() {
        return level > 0;
    }

    public void deativate() {
        level = 0L;
    }
//
//    @JsonIgnore
//    public String getAccessToken(){
//        if (password == null){
//            return "";
//        }
//        return password.substring(0,10);
//    }
    
    public void setRestaurantId(Long restaurantId) {
        this.level = 50L;
        this.restaurantId = restaurantId;
    }

    
    public boolean isRestaurantOwner() {
        return level == 50L;
    }

}
