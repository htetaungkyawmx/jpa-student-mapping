package com.example.jpastudentmapping.dao;

import com.example.jpastudentmapping.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentDao extends JpaRepository<Student, Integer>, CustomStudentDao {

    Optional<Student> findStudentByName(String name);

    Optional<Student> findByName(String name);

    @Query("""
select s from Student s join s.studentSubjects sb join sb.subject sub
where sub.subjectName = ?1 and sb.marks = 
(select max(subt.marks) form StudentSubject subt)
""")
    Optional<Student> getStudentByHighestMarkBySubject(String subjectName);

    @Query("""
select s from Student s where s.name = :name
""")
    Optional<Student> getStudentFormName(@Param("name") String name);

    @Query(value = "select * from student where name = :name", nativeQuery = true)
    Optional<Student> getStudentFormName2(@Param("name") String name);

}

