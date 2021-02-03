package com.technicaltask.slmarta.message;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class MessageService {

    private final MessageRepository messageRepository;

    public List<Message> getMessagesByEmail(String email){
        return messageRepository.findAllByEmail(email);
    }

    public MessageDto saveMessage(MessageDto messageDto){
        UUID id = UUID.randomUUID();
        Message message = MessageMapper.INSTANCE.mapDtoToMessage(messageDto);
        messageRepository.save(message, id);
        return messageDto;
    }
}
