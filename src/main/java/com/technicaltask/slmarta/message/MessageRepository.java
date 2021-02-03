package com.technicaltask.slmarta.message;

import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;

import java.util.List;
import java.util.UUID;

public interface MessageRepository extends CassandraRepository<Message, UUID> {

    @AllowFiltering
    List<Message> findAllByMagicNumber(Integer number);
    List<Message> findAllByEmail(String email);
    Message save(Message message, UUID id);
}
