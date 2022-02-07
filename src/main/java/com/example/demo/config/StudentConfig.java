package com.example.demo.config;

import com.example.demo.repository.StudentRepository;
import com.example.demo.student.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(
            StudentRepository studentRepository){
             return args->{
                Student mole = new Student(
                         "Mole Solanke",
                         "w@gmail.com",
                         LocalDate.of(1945, Month.FEBRUARY,20)


                 );
                    Student funke =   new Student(
                                 "Funke Solanke",
                                 "funke@gmail.com",
                                 LocalDate.of(1998, Month.FEBRUARY,19)


                         );
                       Student wole =   new Student(

                                 "Wole Ajayi",
                                 "wole@gmail.com",
                                 LocalDate.of(2020, Month.FEBRUARY,20)


                         );
                         Student pearl =new Student(

                                 "Pearl Solanke",
                                 "pearl@gmail.com",
                                 LocalDate.of(2000, Month.SEPTEMBER,13)

                         );
                 studentRepository.saveAll(
                         List.of(mole,funke,wole,pearl)
                 );

             } ;


    };
}
