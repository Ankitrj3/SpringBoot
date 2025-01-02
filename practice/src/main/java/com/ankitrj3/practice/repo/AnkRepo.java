package com.ankitrj3.practice.repo;


import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.ankitrj3.practice.Entry.Entry;

public interface AnkRepo extends MongoRepository<Entry,ObjectId>{
    
    
}
