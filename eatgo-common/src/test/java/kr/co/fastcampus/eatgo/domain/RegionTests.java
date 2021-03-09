package kr.co.fastcampus.eatgo.domain;


import org.junit.Test;


import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class RegionTests {


    @Test
    public void creation(){
        Region region = Region.builder().name("Seoul").build();

        assertThat(region.getName(), is("Seoul"));

    }
}