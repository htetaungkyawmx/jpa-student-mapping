package com.example.jpastudentmapping.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final ProvinceDao provinceDao;
    private final StudentDao studentDao;
    private final StudentSubjectDao studentSubjectDao;
    private final SubjectDao subjectDao;

    public List<Student> studentByExample(Example<Student> studentExample) {
        return studentDao.findAll(studentExample);
    }

    public Student findStudentHighestMarksInSubject(String subjectName) {
        return studentDao.getStudentByHighestMarkBySubject(subjectName)
                .get();
    }

    public Student findByName(String name) {
        return studentDao.getStudentFromName2(name)
                .get();
    }

    public Student getStudentByNameCustom(String name) {
        return studentDao.getStudentByName(name)
                .orElseThrow(EntityNotFoundException::new);
    }

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
        student2.addStudentSubject(studentSubject3);
        subject2.addStudentSubject(studentSubject3);

        StudentSubject studentSubject4 = new StudentSubject(92);
        student3.addStudentSubject(studentSubject4);
        subject3.addStudentSubject(studentSubject4);

        StudentSubject studentSubject5 = new StudentSubject(93);
        student4.addStudentSubject(studentSubject5);
        subject1.addStudentSubject(studentSubject5);

        StudentSubject studentSubject6 = new StudentSubject(84);
        student5.addStudentSubject(studentSubject6);
        subject1.addStudentSubject(studentSubject6);

        provinceDao.save(province1);
        provinceDao.save(province2);

        studentDao.save(student1);
        studentDao.save(student2);
        studentDao.save(student3);
        studentDao.save(student4);
        studentDao.save(student5);

        subjectDao.save(subject1);
        subjectDao.save(subject2);
        subjectDao.save(subject3);

        studentSubjectDao.save(studentSubject1);
        studentSubjectDao.save(studentSubject2);
        studentSubjectDao.save(studentSubject3);
        studentSubjectDao.save(studentSubject4);
        studentSubjectDao.save(studentSubject5);
        studentSubjectDao.save(studentSubject6);

    }
}
