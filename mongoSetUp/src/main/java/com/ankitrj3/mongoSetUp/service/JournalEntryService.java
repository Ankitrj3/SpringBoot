package com.ankitrj3.mongoSetUp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import com.ankitrj3.mongoSetUp.entity.JournalEntry;
import com.ankitrj3.mongoSetUp.repository.RepositoryTaklu;

@Component
public class JournalEntryService {
    
    @Autowired
    private RepositoryTaklu repository;
    
    public void saveJournalEntry(JournalEntry journalEntry){
        repository.save(journalEntry);
    }
    public List<JournalEntry> getAllJournalEntries(){
        return repository.findAll();
    }
    public void deleteJournalEntry(String id){
        repository.deleteById(id);
    }
    

}
