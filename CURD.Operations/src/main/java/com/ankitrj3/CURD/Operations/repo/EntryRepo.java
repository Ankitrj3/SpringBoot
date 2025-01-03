package com.ankitrj3.CURD.Operations.repo;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.ankitrj3.CURD.Operations.Entry.EntityEntry;

public interface EntryRepo extends MongoRepository<EntityEntry,ObjectId>{
    
}
