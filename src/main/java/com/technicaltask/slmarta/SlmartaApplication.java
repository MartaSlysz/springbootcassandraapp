package com.technicaltask.slmarta;

import com.technicaltask.slmarta.message.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.UUID;

@SpringBootApplication
public class SlmartaApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(SlmartaApplication.class);

    private static Message newMessage(String email, String title, String content, int magicNumber){
        return new Message(UUID.randomUUID().toString(), email, title, content, magicNumber);
    }


    public static void main(String[] args) {
        SpringApplication.run(SlmartaApplication.class, args);
    }

}
