package com.ankitrj3.practice.services;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import com.ankitrj3.practice.Entry.Entry;
import com.ankitrj3.practice.repo.AnkRepo;

@Component
public class AnkService {
    @Autowired
    private AnkRepo ankRepo;

    public List<Entry> getAll(){
        return ankRepo.findAll();
    }
    public void saveEntry(Entry entry){
        ankRepo.save(entry);
    }
    public void deleteEntry(ObjectId id){
        ankRepo.deleteById(id);
    }
    
    public Optional<Entry> findEntry(ObjectId id){
        return ankRepo.findById(id);
    }
}
