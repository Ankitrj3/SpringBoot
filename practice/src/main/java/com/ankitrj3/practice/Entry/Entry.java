package com.ankitrj3.practice.Entry;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.NonNull;

@Document(collection = "ank")
public class Entry {
    @Id
    private ObjectId id;
    @NonNull
    private String title;
    @NonNull
    private String description;

    // Getter for id
    public ObjectId getId() {
        return id;
    }

    // Setter for id
    public void setId(ObjectId id) {
        this.id = id;
    }


    public String getTitle() {

        return title;

    }
    public void setTitle(String title) {

        this.title = title;

    }
    public String getDescription() {

        return description;

    }
    public void setDescription(String description) {

        this.description = description;
    }
   
}
