package com.example.demo.controllers;

import com.example.demo.service.StudentService;
import com.example.demo.student.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/vi/student")
public class StudentController {
    @Autowired
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getStudents(){
         return this.studentService.getStudents();

    }
    @PostMapping
    public void registerNewStudent(@RequestBody Student student){
       this.studentService.saveNewStudent(student);
    }

    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long studentId){
       if(studentId == null || studentId == 0 ){
           throw new IllegalStateException("Student Id is missing");
       }
       studentService.deleteStudentByID(studentId);
    }

    @PutMapping(path ="{studentId}")
    public void updateStudent(
            @PathVariable("studentId")   Long studentId,
            @RequestParam(required = false)  String name,
             @RequestParam(required = false)  String email ){
        if(studentId == null || studentId == 0 ){
            throw new IllegalStateException("Student Id is missing");
        }
        studentService.updateStudent(studentId,name,email);
    }
}
