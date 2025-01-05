package com.ankitrj3.roggers.springsecurity.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import com.mongodb.lang.NonNull;

import lombok.Data;

@Data
public class Student {
    @Id
    private ObjectId id;
    @NonNull
    private String name;
    @NonNull
    private int marks;
}
