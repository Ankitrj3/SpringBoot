package com.ankitrj3.RESTFULL.APIs.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection ="GeneralEntry")
public class GeneralEntry {
    @Id
    private ObjectId id;
    private String name;
    
}
