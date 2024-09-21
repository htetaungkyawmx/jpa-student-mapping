package com.example.jpastudentmapping.service;

import com.example.jpastudentmapping.dao.ProvinceDao;
import com.example.jpastudentmapping.dao.StudentDao;
import com.example.jpastudentmapping.dao.StudentSubjectDao;
import com.example.jpastudentmapping.dao.SubjectDao;
import com.example.jpastudentmapping.entity.Province;
import com.example.jpastudentmapping.entity.Student;
import com.example.jpastudentmapping.entity.StudentSubject;
import com.example.jpastudentmapping.entity.Subject;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final ProvinceDao provinceDao;
    private final StudentDao studentDao;
    private final StudentSubjectDao studentSubjectDao;
    private final SubjectDao subjectDao;

    @Transactional
    public void createDb() {
        Province province1 = new Province("Sule");
        Province province2 = new Province("Hlaing");

        Student student1 = new Student("John Doe",19,"john@doe.com");
        Student student2 = new Student("Marry James",29,"marry@james.com");
        Student student3 = new Student("Thomas Shall",39,"thomas@shall.com");
        Student student4 = new Student("Jame Coi",49,"jame@coi.com");
        Student student5 = new Student("Shone Lio",22,"shone@liio.com");

        Subject subject1 = new Subject("Java", "001", 2000, 6);
        Subject subject2 = new Subject("Python", "002", 2500, 6);
        Subject subject3 = new Subject("React", "003", 3000, 6);

        province1.addStudent(student1);
        province1.addStudent(student2);
        province1.addStudent(student3);

        province2.addStudent(student4);
        province2.addStudent(student5);

        StudentSubject studentSubject1 = new StudentSubject(90);
        student1.addStudentSubject(studentSubject1);
        subject1.addStudentSubject(studentSubject1);

        StudentSubject studentSubject2 = new StudentSubject(80);
        student1.addStudentSubject(studentSubject2);
        subject2.addStudentSubject(studentSubject2);

        StudentSubject studentSubject3 = new StudentSubject(70);

    }
}
