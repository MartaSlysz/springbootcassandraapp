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

    public List<Message> getMessagesByMagicNumber(int magicNumber){
        return messageRepository.findAllByMagicNumber(magicNumber);
    }

    public void deleteMessagesByMagicNumber(int magicNumber){
        List<Message> messageList = messageRepository.findAllByMagicNumber(magicNumber);
        for (Message m: messageList) {
            messageRepository.delete(m);
        }
    }

    public MessageDto saveMessage(MessageDto messageDto){
        Message message = MessageMapper.INSTANCE.mapDtoToMessage(messageDto);
        String uuid = UUID.randomUUID().toString();
        message.setId(uuid);
        messageRepository.save(message);
        return MessageMapper.INSTANCE.mapMessageToDto(message);
    }
}
