package com.ankitrj3.RESTFULL.APIs.controller;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ankitrj3.RESTFULL.APIs.entity.GeneralEntry;
import com.ankitrj3.RESTFULL.APIs.entity.UserEntity;
import com.ankitrj3.RESTFULL.APIs.services.UserService;
import com.ankitrj3.RESTFULL.APIs.services.serviceAnk;

@RestController
@RequestMapping("/api")
public class Generalcontroller {

    @Autowired
    private serviceAnk service;
    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<?> getEntry() {
        List<GeneralEntry> entry = service.getall();
        if (entry.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(entry, HttpStatus.OK);
    }

    @PostMapping( "/{userName}" )
    @Transactional
    public ResponseEntity<?> storeEntry(@RequestBody GeneralEntry entry, @PathVariable String userName) {
        try {
            // service.saveEntry(entry);
            UserEntity user = userService.findByUserName(userName);
            service.saveEntry(entry);
            user.getEntry().add(entry);
            // user.setEntry(null);
            userService.saveUser(user);

            return new ResponseEntity<>(entry, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping
    public ResponseEntity<?> removeEntry(@PathVariable ObjectId id) {
        try {
            service.deleteEntry(id);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getEntry(@PathVariable ObjectId id) {
        GeneralEntry ent = service.getEntryById(id).orElse(null);
        if (ent == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(ent, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateEntry(@PathVariable ObjectId id, @RequestBody GeneralEntry entry) {
        GeneralEntry old = service.getEntryById(id).orElse(null);
        if (old == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        old.setName(old.getName() != null ? entry.getName() : old.getName());
        service.saveEntry(old);
        return new ResponseEntity<>(old, HttpStatus.ACCEPTED);
    }

}
