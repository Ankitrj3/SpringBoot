package com.ankitrj3.RESTFULL.APIs.controller;

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

import com.ankitrj3.RESTFULL.APIs.entity.UserEntity;
import com.ankitrj3.RESTFULL.APIs.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired 
    private UserService userService;

    @GetMapping("/{Username}")
    public ResponseEntity<?>getUsers(@PathVariable String Username){
        UserEntity user = userService.findByUserName(Username);
        if(user==null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(user,HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<?>addUser(@RequestBody UserEntity user){
        try{
            userService.saveUser(user);
            return new ResponseEntity<>(user,HttpStatus.CREATED);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?>deleteUser(@PathVariable ObjectId id){
        try{
            userService.deleteUser(id);
            return new ResponseEntity<>(id,HttpStatus.ACCEPTED);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping("/{Username}")
    public ResponseEntity<?>deleteUser(@PathVariable String Username){
        UserEntity user = userService.findByUserName(Username);
        if(user==null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        userService.deleteUser(user.getId());
        return new ResponseEntity<>(user,HttpStatus.ACCEPTED);
    }
    
    @PutMapping("/{Username}")
    public ResponseEntity<?>updateUser(@PathVariable String Username,@RequestBody UserEntity userEntity){
        UserEntity user = userService.findByUserName(Username);
        if(user==null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        userEntity.setId(user.getId());
        userService.saveUser(userEntity);
        return new ResponseEntity<>(userEntity,HttpStatus.ACCEPTED);
    }

}
