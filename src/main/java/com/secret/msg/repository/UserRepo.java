package com.secret.msg.repository;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.secret.msg.entities.UserData;

public interface UserRepo  extends MongoRepository<UserData, ObjectId> {
	Optional<UserData> findByEmail(String email); 

}
