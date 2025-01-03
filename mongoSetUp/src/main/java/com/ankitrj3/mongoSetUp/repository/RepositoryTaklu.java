package com.ankitrj3.mongoSetUp.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.ankitrj3.mongoSetUp.entity.JournalEntry;

public interface RepositoryTaklu extends MongoRepository<JournalEntry, String> {

    
} 
