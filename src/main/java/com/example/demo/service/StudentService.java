package com.example.demo.service;

import com.example.demo.repository.StudentRepository;
import com.example.demo.student.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService  {
    @Autowired
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
      return this.studentRepository.findAll();
    }

    public void saveNewStudent(Student student){
        try {
            Optional<Student> studentEmail =
                    this.studentRepository.findByEmail(student.getEmail());
            if(studentEmail.isPresent()){
                throw new IllegalStateException("Email taken");

            }
            this.studentRepository.save(student);

        }catch (Exception e){

        }

    }

    public void deleteStudentByID(Long studentId) {
        boolean studentExists =studentRepository.existsById(studentId);
        if(!studentExists){
            throw new IllegalStateException("Student with ID "+ studentId +"does not exist");
        }
        studentRepository.deleteById(studentId);
    }

    @Transactional
    public void updateStudent(Long studentId,String name,  String email) {
        Optional<Student> oldStudent  = studentRepository.findById(studentId);
        System.out.println(email);
        System.out.println(name);
        Student student = oldStudent.get();

        if(!oldStudent.isPresent()){
            throw new IllegalStateException("Student with ID "+ studentId +"does not exist");
        }

        if(email!= null && email.length() >0 ){
            Optional<Student> exists = studentRepository.findByEmail(email);
            if(exists.isPresent()){
                throw new IllegalStateException("Email Already Exist");
            }
              student.setEmail(email);

        }
         if(name != null && name.length()> 0  ){
               student.setName(name);
             System.out.println("name"+Objects.toString(student));

         }
       // student =  studentRepository.save(student);
        System.out.println(Objects.toString(student));




    }
}
