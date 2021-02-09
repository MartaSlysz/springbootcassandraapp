package com.technicaltask.slmarta;

import com.technicaltask.slmarta.message.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static com.technicaltask.slmarta.testhelpers.testMessage.*;
import static com.technicaltask.slmarta.testhelpers.testMessageDto.hardcodedDto;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(MessageController.class)
public class MessageControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MessageService messageService;

    @MockBean
    private MessageController messageController;

    @Test
    public void shouldReturnMessagesByEmailGiven() throws Exception {
        Message message = messageWithEmailGiven();
        MessageDto dto = MessageMapper.INSTANCE.mapMessageToDto(message);
        List<Message> messageList = new ArrayList<>();
        messageList.add(message);
        given(messageController.getAllMessagesByEmail(message.getEmail())).willReturn(new ArrayList<>(messageList));
        mockMvc.perform(get("/api/messages/hello@example.com")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.[0].email", is(dto.getEmail())))
                .andExpect(jsonPath("$.[0].magicNumber", is(dto.getMagicNumber())))
                .andExpect(jsonPath("$.[0].title", is(dto.getTitle())))
                .andExpect(jsonPath("$.[0].content", is(dto.getContent())));

    }

    @Test
    public void shouldDeleteMessagesByMagicNumberGiven() throws Exception {
        Message message = messageWithMagicNumberGiven();
        MessageDto dto = MessageMapper.INSTANCE.mapMessageToDto(message);
        List<Message> messageList = new ArrayList<>();
        messageList.add(message);
        MagicNumber magicNumber = new MagicNumber();
        magicNumber.setMagicNumber(message.getMagicNumber());
        given(messageController.getAllMessagesByMagicNumber(magicNumber)).willReturn(new ArrayList<>(messageList));
        mockMvc.perform(post("/send")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "    \"magicNumber\": 345\n" +
                        "}"))
                .andExpect(status().isNotFound());
    }

    @Test
    public void shouldSaveMessage() throws Exception {
        MessageDto dto = hardcodedDto();
        given(messageController.sendMessage(dto)).willReturn(dto);
        mockMvc.perform(post("/api/message")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                "    \"email\": \"jan.kowalski@example.com\",\n" +
                "    \"title\": \"Interview\",\n" +
                "    \"content\": \"simpletext\",\n" +
                "    \"magicNumber\": 101\n" +
                "}"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("email", is(dto.getEmail())))
                .andExpect(jsonPath("magicNumber", is(dto.getMagicNumber())))
                .andExpect(jsonPath("title", is(dto.getTitle())))
                .andExpect(jsonPath("content", is(dto.getContent())));
    }

}
