package com.ankitrj3.practice.controller;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ankitrj3.practice.Entry.Entry;
import com.ankitrj3.practice.services.AnkService;

@RestController
@RequestMapping("/ank")
public class AnkContoller {
    @Autowired
    private AnkService ankService;
    
    @GetMapping//This for showing all entries
    public List<Entry> getAllEntry(){
        return ankService.getAll();
    }

    @PostMapping//This for creating entry
    public String createEntry(@RequestBody Entry ent){
        ankService.saveEntry(ent);
        return "Saved";
    }
    @DeleteMapping("/{id}")//This for deleting entry
    public String deleteEntryById(@PathVariable ObjectId id){
        ankService.deleteEntry(id);
        return "Deleted";
    }

    @GetMapping("/{id}")//This for showing single entry
    public Entry getEntryById(@PathVariable ObjectId id){
        return ankService.findEntry(id).orElse(null);
    }
    @PutMapping("/{id}")//This for updating entry
    public String updateEntry(@PathVariable ObjectId id,@RequestBody Entry ent){
        Entry old = ankService.findEntry(id).orElse(null);

        if(old == null){
            return "Not Found";
        }else{
            old.setTitle(ent.getTitle()!= null ? ent.getTitle() : old.getTitle());
            old.setDescription(ent.getDescription()!= null ? ent.getDescription() : old.getDescription());
            ankService.saveEntry(old);
        }
        return "Updated";
    }

    

}
