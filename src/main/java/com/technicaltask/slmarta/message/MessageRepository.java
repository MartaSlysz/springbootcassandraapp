package com.technicaltask.slmarta.message;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends CassandraRepository<Message, String> {

    @Query("SELECT * FROM messages WHERE magicNumber=:number ALLOW FILTERING")
    List<Message> findAllByMagicNumber(@Param("number") int number);
    @Query("SELECT * FROM messages WHERE email=:email ALLOW FILTERING")
    List<Message> findAllByEmail(@Param("email") String email);
}
