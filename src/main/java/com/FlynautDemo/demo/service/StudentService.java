package com.FlynautDemo.demo.service;

import com.FlynautDemo.demo.Repository.StudentRepository;
import com.FlynautDemo.demo.entity.Students;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository stdRepo;

    public String saveStudent(Students std) {
        try{
            stdRepo.save(std);
            return "Data Saved Succesfully";
        } catch (Exception e) {
            e.printStackTrace();
            return "unable to save data" +e.getMessage();
        }
    }
    public List<Students> getStudents(){
        List<Students> allStudents = stdRepo.findAll();
        if(allStudents!=null || allStudents.size()>0)
        {
            return allStudents;
        }else{
            return null;
        }
    }
    public Students getStudentById(int id){
        Optional<Students> std = stdRepo.findById(id);
        return std.orElse(null);
    }

    public boolean deleteStudent(int id) {
        try {
            Students std = stdRepo.findById(id).orElse(null);
            if (std != null) {
                stdRepo.delete(std);
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
