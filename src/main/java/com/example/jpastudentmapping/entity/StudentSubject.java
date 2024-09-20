package com.example.jpastudentmapping.entity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class StudentSubject extends IdClass{
    private int marks;

    public StudentSubject(int marks) {
        this.marks = marks;
    }
}
