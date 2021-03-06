package kr.co.fastcampus.eatgo.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table
public class Restaurant {

    @Id
    @GeneratedValue
    @Setter
    private Long id;

    @NotNull
    private Long categoryId;

    @NotEmpty
    private  String name;

    @NotEmpty
    private  String address;

    @Transient
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<MenuItem> menuItems ;

    @Transient
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<Review> reviews;


    public  Restaurant(String name, String address){
        this.name=name;
        this.address=address;

    }
    public Restaurant(Long id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;

    }



    public String getInformation() {
        return name + " in " + address;
    }

    public void updateInformation(Long categoryId,
            String name, String address) {
        this.categoryId = categoryId;
        this.name=name;
        this.address=address;

    }

    public void setMenuItems(List<MenuItem> menuItems){
        this.menuItems=new ArrayList<>(menuItems);

    }

    public void setReviews(List<Review> reviews) {
        this.reviews = new ArrayList<>(reviews);
    }
}
