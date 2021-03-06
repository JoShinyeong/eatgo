package kr.co.fastcampus.eatgo.domain;

import org.assertj.core.api.Assert;
import org.junit.Test;


import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class RestaurantTests {


    @Test
    public void creation() {

//        Restaurant restaurant = new Restaurant( 1004L,"Bob zip", "Seoul");
        Restaurant restaurant = Restaurant.builder()
                .id(1004L)
                .name("Bob zip")
                .address("Seoul")
                .build();


        assertThat(restaurant.getId(), is(1004L));
        assertThat(restaurant.getName(), is("Bob zip"));
        assertThat(restaurant.getAddress(), is("Seoul"));

    }

    @Test
    public void information() {

        Restaurant restaurant = Restaurant.builder()
                .id(1004L)
                .name("Bob zip")
                .address("Seoul")
                .build();


        assertThat(restaurant.getInformation(), is("Bob zip in Seoul"));


    }


}