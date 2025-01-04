package com.ankitrj3.RESTFULL.APIs.repo;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.ankitrj3.RESTFULL.APIs.entity.GeneralEntry;

public interface repoAnk extends MongoRepository<GeneralEntry, ObjectId> {
    
}
