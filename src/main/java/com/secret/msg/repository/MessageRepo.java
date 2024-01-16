package com.secret.msg.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.secret.msg.entities.Message;


public interface MessageRepo extends MongoRepository<Message, ObjectId> {

}
