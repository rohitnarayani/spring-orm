package com.spring.jdbc;

import com.spring.jdbc.dao.StudentDao;

import com.spring.jdbc.entities.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(HibConfig.class);

        StudentDao studentDao =  applicationContext.getBean(StudentDao.class);
        Student student = new Student();
        student.setStudentId(7779);
        student.setStudentName("Rajesh");
        student.setStudentCity("Vv nagar");
//        int result = studentDao.insert(student);
//        System.out.println(result);
//        System.out.println(studentDao.getStudent(1));

//        List<Student> students = studentDao.getStudents();
//
//        for (Student s : students) {
//            System.out.println(s);
//        }

//        studentDao.deleteStudent(5);
        studentDao.updateStudent(student);
    }
}
