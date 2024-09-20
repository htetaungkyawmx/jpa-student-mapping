package com.example.jpastudentmapping.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Student extends IdClass{
    private String name;
    private int age;
    private String email;

    @ManyToOne
    private Province province;

    public Student(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }
}
