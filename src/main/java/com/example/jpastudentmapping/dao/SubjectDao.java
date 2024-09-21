package com.example.jpastudentmapping.dao;

import com.example.jpastudentmapping.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectDao extends JpaRepository<Subject, Integer> {

}
