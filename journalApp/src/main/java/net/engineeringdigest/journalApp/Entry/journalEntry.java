package net.engineeringdigest.journalApp.Entry;
import java.util.*;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.engineeringdigest.journalApp.Entity.JournalEntity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("journal")
public class journalEntry {
    
    private Map<Long,JournalEntity> journalEntry = new HashMap<>();
    
    @GetMapping
    public List<JournalEntity> getAll(){
        return new ArrayList<>(journalEntry.values());
    }
    @PostMapping
    //@RequestBody is used to send input through body raw
    public String createEntry(@RequestBody JournalEntity journalEntity){
        journalEntry.put(journalEntity.getId(),journalEntity);
        return "Entry Created";
    }

    @GetMapping("/id/{myid}")
    public JournalEntity getEntryById(@PathVariable Long myid){//myid is instance of PathVariable
        return journalEntry.get(myid);
    }
    @DeleteMapping("/id/{myid}")
    public String deleteEntryById(@PathVariable Long myid){//myid is instance of PathVariable
        journalEntry.remove(myid);
        return "Entry Deleted";
    }
    @PutMapping("/id/{myid}")
    public String updateEntryById(@RequestBody JournalEntity journalEntity){
        journalEntry.put(journalEntity.getId(),journalEntity);
        return "Entry Updated";
    }
}
