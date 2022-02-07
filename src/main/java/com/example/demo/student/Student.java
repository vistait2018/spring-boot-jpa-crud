package com.example.demo.student;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String name;
    private String email;
    private LocalDate dob;
    @Transient
    private int age;

    public Student() {

    }

    public Student(Long id,
                   String name,
                   String email,
                   LocalDate dob
                  ) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.dob = dob;

    }

    public Student(String name,
                   String email,
                   LocalDate dob
                   ) {
        this.name = name;
        this.email = email;
        this.dob = dob;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public int getAge() {
        return Period.between(this.dob,LocalDate.now()).getYears();
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", dob=" + dob +
                ", age=" + age +
                '}';
    }
}
