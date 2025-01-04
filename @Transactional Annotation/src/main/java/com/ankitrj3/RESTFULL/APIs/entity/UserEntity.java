package com.ankitrj3.RESTFULL.APIs.entity;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.NonNull;

import lombok.Data;

@Data
@Document(collection ="User")
public class UserEntity {
    
    @Id
    private ObjectId id;
    @Indexed(unique = true)//This is used to create an index on the field
    @NonNull
    private String userName;
    @NonNull
    private String password;
    
    @DBRef//This is used to create a reference to another collection
    private List<GeneralEntry> entry = new ArrayList<>();
    //This is used to create a list of references to another collection
}
