package com.example.jpastudentmapping.dao;

import com.example.jpastudentmapping.entity.StudentSubject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentSubjectDao extends JpaRepository<StudentSubject, Integer> {

}
