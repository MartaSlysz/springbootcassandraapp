package com.technicaltask.slmarta;

import com.technicaltask.slmarta.message.Message;
import com.technicaltask.slmarta.message.MessageRepository;
import org.junit.After;
import org.junit.ClassRule;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testcontainers.containers.CassandraContainer;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.ArrayList;
import java.util.List;

import static com.technicaltask.slmarta.testhelpers.testMessage.message;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Testcontainers
public class MessageRepositoryTest {

    @Autowired
    MessageRepository messageRepository;

    @ClassRule
    public static CassandraContainer cassandraContainer;

    @Test
    public void shouldFindMessageByMagicNumberGiven(){
        Message message = message();
        messageRepository.save(message);
        List<Message> messageList = new ArrayList<>();
        messageList.add(message);
        List<Message> found = messageRepository.findAllByMagicNumber(message.getMagicNumber());
        assertEquals(found.get(found.size()-1).getMagicNumber(), messageList.get(messageList.size()-1).getMagicNumber());
        messageRepository.delete(message);
    }

    @Test
    public void shouldFindMessageByEmailGiven(){
        Message message = message();
        messageRepository.save(message);
        List<Message> messageList = new ArrayList<>();
        messageList.add(message);
        List<Message> found = messageRepository.findAllByEmail(message.getEmail());
        assertEquals(found.get(found.size()-1).getEmail(), messageList.get(messageList.size()-1).getEmail());
        messageRepository.delete(message);
    }

}
