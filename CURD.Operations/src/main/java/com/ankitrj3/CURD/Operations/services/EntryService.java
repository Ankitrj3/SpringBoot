package com.ankitrj3.CURD.Operations.services;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ankitrj3.CURD.Operations.Entry.EntityEntry;
import com.ankitrj3.CURD.Operations.repo.EntryRepo;

@Component
public class EntryService {
    @Autowired
    private EntryRepo entryRepo;
    public List<EntityEntry>getAll(){
        return entryRepo.findAll();
    }
    public void saveEntity(EntityEntry entityEntry){
        entryRepo.save(entityEntry);
    }
    public void deleteEntity(ObjectId id) {
        entryRepo.deleteById(id);
    }
    public Optional<EntityEntry> getEntryById(ObjectId id) {
        return entryRepo.findById(id);
    }
   
}
