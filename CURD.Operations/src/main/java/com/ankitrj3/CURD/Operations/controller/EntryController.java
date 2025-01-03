package com.ankitrj3.CURD.Operations.controller;

import java.util.List;

import java.util.Optional;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ankitrj3.CURD.Operations.Entry.EntityEntry;
import com.ankitrj3.CURD.Operations.services.EntryService;

@RestController
@RequestMapping("/entry")
public class EntryController {
    @Autowired
    private EntryService entryService;
    
    @GetMapping
    public ResponseEntity<?>getEntry(){
        List<EntityEntry> response = entryService.getAll();
        if(response.isEmpty()){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity(response,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<EntityEntry> entrySave(@RequestBody EntityEntry entityEntry){
        try{
        entryService.saveEntity(entityEntry);
        return new ResponseEntity(entityEntry,HttpStatus.CREATED);
        }catch(Exception e){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<EntityEntry> gettingEntryById(@PathVariable ObjectId id){
        Optional<EntityEntry> response = entryService.getEntryById(id);
        if(response.isPresent()){
            return new ResponseEntity<>(response.get(),HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEntry(@PathVariable ObjectId id){
        entryService.deleteEntity(id);
        return new ResponseEntity<>("Entry Deleted", HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<EntityEntry> updateEntry(@PathVariable ObjectId id, @RequestBody EntityEntry newEntry){
        Optional<EntityEntry> existingEntry = entryService.getEntryById(id);
        if(existingEntry.isPresent()){
            EntityEntry old = existingEntry.get();
            old.setName(newEntry.getName() != null ? newEntry.getName() : old.getName());
            old.setEmail(newEntry.getEmail() != null ? newEntry.getEmail() : old.getEmail());
            entryService.saveEntity(old);
            return new ResponseEntity<>(old, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
