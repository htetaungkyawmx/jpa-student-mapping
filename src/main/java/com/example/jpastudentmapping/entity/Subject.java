package com.example.jpastudentmapping.entity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Subject extends IdClass{
    private String subjectName;
    private String subjectCode;
    private double fees;
    private int durationMonth;

    public Subject(String subjectName, String subjectCode, double fees, int durationMonth) {
        this.subjectName = subjectName;
        this.subjectCode = subjectCode;
        this.fees = fees;
        this.durationMonth = durationMonth;
    }
}
