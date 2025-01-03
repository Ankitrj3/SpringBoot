package com.ankitrj3.CURD.Operations.Entry;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.NonNull;

import lombok.Data;

@Document(collection = "entry")
@Data
public class EntityEntry {
    @Id
    private ObjectId id;
    @NonNull
    private String name;
    @NonNull
    private String email;
   

}
