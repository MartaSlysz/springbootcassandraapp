package com.technicaltask.slmarta.testhelpers;

import com.github.javafaker.Faker;
import com.technicaltask.slmarta.message.MessageDto;

public class testMessageDto {

    static Faker faker = new Faker();

    public static MessageDto dto(){
        MessageDto dto = MessageDto.builder()
                .content(faker.rickAndMorty().character())
                .email(faker.internet().emailAddress())
                .title(faker.book().title())
                .magicNumber(faker.number().randomDigit())
                .build();
        return dto;
    }

    public static MessageDto hardcodedDto(){
        MessageDto dto = MessageDto.builder()
                .content("simpletext")
                .email("jan.kowalski@example.com")
                .title("Interview")
                .magicNumber(101)
                .build();
        return dto;
    }
}
