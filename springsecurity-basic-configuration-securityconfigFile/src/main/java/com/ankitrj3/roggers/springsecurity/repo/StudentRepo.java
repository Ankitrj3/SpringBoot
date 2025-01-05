package com.ankitrj3.roggers.springsecurity.repo;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.ankitrj3.roggers.springsecurity.entity.Student;

public interface StudentRepo extends MongoRepository<Student, ObjectId> {
    
}
