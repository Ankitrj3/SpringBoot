package com.ankitrj3.roggers.springsecurity.services;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ankitrj3.roggers.springsecurity.entity.Student;
import com.ankitrj3.roggers.springsecurity.repo.StudentRepo;

@Component
public class StudentService {
    @Autowired
    private StudentRepo studentRepo;
    
    public Student saveStudent(Student student) {
        return studentRepo.save(student);
    }
    
    public List<Student> getStudents() {
        return studentRepo.findAll();
    }
    
    public Student getStudent(ObjectId id) {
        return studentRepo.findById(id).orElse(null);
    }
    
    public void deleteStudent(ObjectId id) {
        studentRepo.deleteById(id);
    }
    
    public Student updateStudent(ObjectId id, Student student) {
        student.setId(id);
        return studentRepo.save(student);
    }


}
