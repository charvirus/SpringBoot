package com.charvirus.book.springboot.web.dto;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class HelloResponseDtoTest {
    @Test
    public void 롬복_기능_테스트(){

        //given
        String name="test";
        int amount = 1000;

        //when
        HelloResponseDto dto = new HelloResponseDto(name,amount);

        //then
        assertThat(dto.getNAME()).isEqualTo(name);
        assertThat(dto.getAMOUNT()).isEqualTo(amount);
    }
}