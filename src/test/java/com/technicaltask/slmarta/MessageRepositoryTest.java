package com.technicaltask.slmarta;

import com.github.javafaker.Faker;
import com.technicaltask.slmarta.message.Message;
import com.technicaltask.slmarta.message.MessageRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static com.technicaltask.slmarta.testhelpers.testMessage.message;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

@SpringBootTest
public class MessageRepositoryTest {

    @Autowired
    MessageRepository messageRepository;

    @Test
    public void shouldFindMessageByMagicNumberGiven(){
        Message message = message();
        messageRepository.save(message);
        List<Message> messageList = new ArrayList<>();
        messageList.add(message);
        List<Message> found = messageRepository.findAllByMagicNumber(message.getMagicNumber());
        assertEquals(found.get(found.size()-1).getMagicNumber(), messageList.get(messageList.size()-1).getMagicNumber());
    }

    @Test
    public void shouldFindMessageByEmailGiven(){
        Message message = message();
        messageRepository.save(message);
        List<Message> messageList = new ArrayList<>();
        messageList.add(message);
        List<Message> found = messageRepository.findAllByEmail(message.getEmail());
        assertEquals(found.get(found.size()-1).getEmail(), messageList.get(messageList.size()-1).getEmail());
    }


}
