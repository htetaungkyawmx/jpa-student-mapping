package com.example.jpastudentmapping;

import com.example.jpastudentmapping.entity.Student;
import com.example.jpastudentmapping.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Example;

@SpringBootApplication
@RequiredArgsConstructor
public class JpaStudentMappingApplication implements CommandLineRunner {

    private final StudentService studentService;

    public static void main(String[] args) {
        SpringApplication.run(JpaStudentMappingApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        studentService.createDb();

       /* System.out.println("Student By StudentName::");
        System.out.println(studentService.getStudentByNameCustom("John Doe"));*/

        System.out.println("Student By Dynamic Query Example");
        Student s = new Student();
        s.setName("John Doe");
        s.setEmail("john.doe@gmail.com");

        Example<Student> studentExample = Example.of(s);
        System.out.println(studentService.studentByExample(studentExample));

        JPAUtil.checkData("select * from province");
        JPAUtil.checkData("select * from student");
        JPAUtil.checkData("select * from subject");
        JPAUtil.checkData("select * from student_subject");

    }

}
