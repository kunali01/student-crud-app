package com.FlynautDemo.demo.controller;
import com.FlynautDemo.demo.entity.Students;
import com.FlynautDemo.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class StudentController {
    @Autowired
    private StudentService stdService;

    public StudentController(){
        System.out.println("Object of student controller is created");
    }

    @PostMapping("/saveStudent")
    public String saveStudent(@RequestBody Students std){
        try{
            std.setCreated(LocalDate.now());
            std.setModified(LocalDate.now());
           return stdService.saveStudent(std);
        } catch (Exception e) {
            e.printStackTrace();
            return "something went wrong";
        }


    }

    @GetMapping("/getAllStudents")
    public ResponseEntity<?>getAllStudents()
    {
        List<Students> allstd= stdService.getStudents();

        if(allstd!=null){
        return ResponseEntity.ok().body(allstd);
    }else {
            return ResponseEntity.status(404).body("No record found");
        }
    }
    @GetMapping("/getStudentById")
    public ResponseEntity<?>getStudentById(@RequestParam int id)
    {
        Students std = stdService.getStudentById(id);

        if(std!=null){
            return ResponseEntity.ok().body(std);
        }else {
            return ResponseEntity.status(404).body("No record found");
        }
    }

    @PutMapping("/updateStudent/{id}")
    public ResponseEntity<String> updateStudent(@PathVariable int id, @RequestBody Students std) {
        try {
            Students existingstd = stdService.getStudentById(id);

            if (existingstd != null) {
                existingstd.setModified(LocalDate.now());
                existingstd.setEmail(std.getEmail());
                existingstd.setName(std.getName());

                String result = stdService.saveStudent(existingstd);

                return ResponseEntity.ok("Record updated successfully");
            } else {
                return ResponseEntity.status(404).body("Student not found");
            }

        } catch (Exception e) {
            return ResponseEntity.status(505).body("Something went wrong " + e.getMessage());
        }
    }
@DeleteMapping("/deleteStudent/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable int id){
try{
    boolean deleted = stdService.deleteStudent(id);
    if(deleted){
        return ResponseEntity.ok("Student deleted successfully");
    }else {
        return ResponseEntity.status(404).body("Student not found");
    }
} catch (Exception e) {
    e.printStackTrace();
    return ResponseEntity.status(500).body("Something went wrong"+e.getMessage());
}
    }

}
