package com.spring.jdbc.entities;


import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="student")
public class Student {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int studentId;
    private String studentName;
    private String studentCity;
    public int getStudentId() {
        return studentId;
    }
    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }
    public String getStudentName() {
        return studentName;
    }
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", studentCity='" + studentCity + '\'' +
                '}';
    }

    public String getStudentCity() {
        return studentCity;
    }
    public void setStudentCity(String studentCity) {
        this.studentCity = studentCity;
    }
    public Student(int studentId, String studentName, String studentCity) {
        super();
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentCity = studentCity;
    }
    public Student() {
        super();
        // TODO Auto-generated constructor stub
    }
}