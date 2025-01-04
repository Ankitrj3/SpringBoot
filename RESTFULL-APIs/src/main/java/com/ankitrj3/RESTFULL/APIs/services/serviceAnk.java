package com.ankitrj3.RESTFULL.APIs.services;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ankitrj3.RESTFULL.APIs.entity.GeneralEntry;
import com.ankitrj3.RESTFULL.APIs.repo.repoAnk;

@Component
public class serviceAnk {
    @Autowired 
    private repoAnk repo;

    public void saveEntry(GeneralEntry entry){
        repo.save(entry);
    }
    public List<GeneralEntry>getall(){
        return repo.findAll();
    }
    public Optional<GeneralEntry> getEntryById(ObjectId id){
        return repo.findById(id);
    }
    public void deleteEntry(ObjectId id){
        repo.deleteById(id);
    }
}
