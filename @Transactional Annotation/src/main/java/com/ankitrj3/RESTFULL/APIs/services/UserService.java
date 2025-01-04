package com.ankitrj3.RESTFULL.APIs.services;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ankitrj3.RESTFULL.APIs.entity.UserEntity;
import com.ankitrj3.RESTFULL.APIs.repo.UserRepo;

@Component
public class UserService {
    @Autowired
    private UserRepo userRepo;
    
    public void saveUser(UserEntity entry){
        userRepo.save(entry);
    }
    public void deleteUser(ObjectId id){
        userRepo.deleteById(id);
    }
    public UserEntity findByUserName(String name){
        return userRepo.findByUserName(name);
    }
}
