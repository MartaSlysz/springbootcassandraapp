package com.technicaltask.slmarta.message;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface MessageMapper {
    MessageMapper INSTANCE = Mappers.getMapper(MessageMapper.class);

    MessageDto mapMessageToDto(Message message);
    Message mapDtoToMessage(MessageDto messageDto);
}
