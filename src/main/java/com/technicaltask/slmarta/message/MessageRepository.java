package com.technicaltask.slmarta.message;

import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;

import java.util.List;

public interface MessageRepository extends CassandraRepository<Message, String> {

    @AllowFiltering
    List<Message> findAllByMagicNumber(int number);
    void deleteAllByMagicNumber(int number);
    List<Message> findAllByEmail(String email);
}
