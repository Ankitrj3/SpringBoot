package com.ankitrj3.mongoSetUp.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ankitrj3.mongoSetUp.entity.JournalEntry;

import com.ankitrj3.mongoSetUp.service.JournalEntryService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
@RequestMapping("/journalentry")
public class JournalEntryController {
    @Autowired
    private JournalEntryService journalEntryService;

    @GetMapping
    public List<JournalEntry> getAll(){
        return journalEntryService.getAllJournalEntries();
    }    
    @PostMapping
    public String saveJournalEntry(@RequestBody JournalEntry journalEntry){
        journalEntryService.saveJournalEntry(journalEntry);
        return "Journal Entry saved";
    }
    @DeleteMapping("/id/{id}")
    public String deleteJournalEntry(@PathVariable String id){
        journalEntryService.deleteJournalEntry(id);
        return "Journal Entry deleted";
    }
    
    
}
