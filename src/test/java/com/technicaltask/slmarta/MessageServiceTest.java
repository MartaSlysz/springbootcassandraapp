package com.technicaltask.slmarta;

import com.technicaltask.slmarta.message.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static com.technicaltask.slmarta.testhelpers.testMessageDto.dto;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class MessageServiceTest {

    @Mock
    private MessageRepository messageRepository;

    @InjectMocks
    private MessageService messageService;

    @Test
    public void shouldReturnMessagesByEmail(){
        MessageDto dto = dto();
        List<Message> messageList = new ArrayList<>();
        messageList.add(MessageMapper.INSTANCE.mapDtoToMessage(dto));
        messageService.saveMessage(dto);
        given(messageRepository.findAllByEmail(dto.getEmail())).willReturn(new ArrayList<>(messageList));
        List<Message> expected = messageService.getMessagesByEmail(dto.getEmail());
        assertEquals(expected, messageList);
    }

    @Test
    public void shouldReturnMessagesByMagicNumber(){
        MessageDto dto = dto();
        List<Message> messageList = new ArrayList<>();
        messageList.add(MessageMapper.INSTANCE.mapDtoToMessage(dto));
        messageService.saveMessage(dto);
        given(messageRepository.findAllByMagicNumber(dto.getMagicNumber())).willReturn(new ArrayList<>(messageList));
        List<Message> expected = messageService.getMessagesByMagicNumber(dto.getMagicNumber());
        assertEquals(expected, messageList);
    }

    @Test
    public void shouldDeleteMessagesWithMagicNumberGiven(){
        MessageDto dto = dto();
        messageService.deleteMessagesByMagicNumber(dto.getMagicNumber());
        assertThat(messageService.getMessagesByMagicNumber(dto.getMagicNumber())).isEmpty();
    }

    @Test
    public void shouldSaveMessage(){
        MessageDto dto = dto();
        MessageDto savedMessage = messageService.saveMessage(dto);
        assertEquals(dto, savedMessage);
    }

}
