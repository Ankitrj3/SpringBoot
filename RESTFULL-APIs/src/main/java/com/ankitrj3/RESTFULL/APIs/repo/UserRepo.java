package com.ankitrj3.RESTFULL.APIs.repo;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.ankitrj3.RESTFULL.APIs.entity.UserEntity;

public interface UserRepo extends MongoRepository<UserEntity,ObjectId>{
    UserEntity findByUserName(String userName);
}
