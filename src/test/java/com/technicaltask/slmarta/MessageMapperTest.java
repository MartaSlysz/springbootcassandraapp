package com.technicaltask.slmarta;

import com.technicaltask.slmarta.message.Message;
import com.technicaltask.slmarta.message.MessageDto;
import com.technicaltask.slmarta.message.MessageMapper;
import org.junit.jupiter.api.Test;

import static com.technicaltask.slmarta.testhelpers.testMessage.message;
import static com.technicaltask.slmarta.testhelpers.testMessageDto.dto;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MessageMapperTest {
    
    @Test
    public void shouldMapDtotoMessage(){
        MessageDto dto = dto();
        Message message = MessageMapper.INSTANCE.mapDtoToMessage(dto);

        assertEquals(dto.getMagicNumber(), message.getMagicNumber());
        assertEquals(dto.getEmail(), message.getEmail());
        assertEquals(dto.getContent(), message.getContent());
        assertEquals(dto.getTitle(), message.getTitle());
    }

    @Test
    public void shouldMapMessageToDto(){
        Message message = message();
        MessageDto dto = MessageMapper.INSTANCE.mapMessageToDto(message);

        assertEquals(dto.getMagicNumber(), message.getMagicNumber());
        assertEquals(dto.getEmail(), message.getEmail());
        assertEquals(dto.getContent(), message.getContent());
        assertEquals(dto.getTitle(), message.getTitle());
    }
}
