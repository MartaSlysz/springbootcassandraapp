package com.technicaltask.slmarta.testhelpers;

import com.github.javafaker.Faker;
import com.technicaltask.slmarta.message.Message;

import java.util.UUID;

public class testMessage {

    static Faker faker = new Faker();

    public static Message message(){
        Message message = Message.builder()
                .content(faker.rickAndMorty().character())
                .email(faker.internet().emailAddress())
                .title(faker.book().title())
                .magicNumber(faker.number().randomDigit())
                .id(UUID.randomUUID().toString())
                .build();
        return message;
    }

    public static Message messageWithEmailGiven(){
        Message message = Message.builder()
                .content(faker.rickAndMorty().character())
                .email("hello@example.com")
                .title(faker.book().title())
                .magicNumber(faker.number().randomDigit())
                .id(UUID.randomUUID().toString())
                .build();
        return message;
    }

    public static Message messageWithMagicNumberGiven(){
        Message message = Message.builder()
                .content(faker.rickAndMorty().character())
                .email(faker.internet().emailAddress())
                .title(faker.book().title())
                .magicNumber(356)
                .id(UUID.randomUUID().toString())
                .build();
        return message;
    }
}
