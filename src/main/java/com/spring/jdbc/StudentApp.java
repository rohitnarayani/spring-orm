package com.spring.jdbc;

import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.entities.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

public class StudentApp {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(HibConfig.class);
        StudentDao studentDao =  applicationContext.getBean(StudentDao.class);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int id;
        String name,city;
        outer:while(true){
            try{
                System.out.println("PRESS 1 for add student");
                System.out.println("PRESS 2 for display single student");
                System.out.println("PRESS 3 for display all student");
                System.out.println("PRESS 4 for delete a student");
                System.out.println("PRESS 5 for update a student");
                System.out.println("PRESS 6 for exit");

                System.out.println("Enter your choice: ");
                int choice = Integer.parseInt(br.readLine());

                switch (choice){
                    case 1:
                        System.out.println("Enter student's id: ");
                        id = Integer.parseInt(br.readLine());

                        System.out.println("Enter student's name: ");
                        name = br.readLine();

                        System.out.println("Enter student's city: ");
                        city = br.readLine();

                        Student student = new Student(id, name, city);
                        int sid = studentDao.insert(student);

                        System.out.println();
                        System.out.println(student+" Student Added");
                        System.out.println("**********************************");
                        System.out.println();
                        break;

                    case 2:
                        System.out.println();
                        System.out.println("**********************************");
                        System.out.println("Enter student's id: ");
                        id = Integer.parseInt(br.readLine());

                        Student student1 = studentDao.getStudent(id);

                        System.out.println();
                        if(student1 == null){
                            System.out.println("Student with this id does not exist");
                        }
                        else {
                            System.out.println(student1.getStudentId());
                            System.out.println(student1.getStudentName());
                            System.out.println(student1.getStudentCity());
                        }

                        System.out.println("****************************************");
                        System.out.println();
                        break;
                    case 3:
                        System.out.println();
                        System.out.println("****************************************");

                        List<Student> studentList = studentDao.getStudents();

                        if(studentList.size() == 0){
                            System.out.println("No students available");
                            System.out.println();
                            System.out.println("****************************************");
                            System.out.println();
                            System.out.println();
                        }
                        for(Student s : studentList){
                            System.out.println("------------------------------------");
                            System.out.println(s.getStudentId());
                            System.out.println(s.getStudentName());
                            System.out.println(s.getStudentCity());
                            System.out.println("-------------------------------------");
                        }

                        System.out.println();
                        break;

                    case 4:
                        System.out.println();
                        System.out.println("*****************************************");
                        System.out.println("Enter student's id: ");
                        id =  Integer.parseInt(br.readLine());

                        boolean result = studentDao.deleteStudent(id);

                        if(result){
                            System.out.println("Student deleted successfully");
                        }
                        else {
                            System.out.println("Student with this id does not exist");
                        }

                        System.out.println();
                        break;

                    case 5:
                        System.out.println();
                        System.out.println("****************************************");

                        System.out.println("Enter old student's id: ");
                        id = Integer.parseInt(br.readLine());

                        Student s = studentDao.getStudent(id);
                        if(s == null) {
                            System.out.println("Student with this id does not exist");
                            System.out.println();
                            break;
                        }
                        System.out.println("Enter new Name: ");
                        name = br.readLine();

                        System.out.println("Enter new city: ");
                        city = br.readLine();
                        Student student2 = new Student(id, name, city);
                        studentDao.updateStudent(student2);

                        System.out.println();
                        System.out.println();
                        System.out.println("Student updated successfully");
                        System.out.println("****************************************");
                        System.out.println();
                        break;
                    case 6:
                        System.out.println();
                        System.out.println("*********************************");
                        System.out.println("Thank u for using my application...");
                        System.out.println("Bye");
                        System.out.println("*********************************");
                        System.out.println();
                        break outer;
                }
            }
            catch (Exception e){
                System.out.println("Try again");
                System.out.println(e.getMessage());
            }
        }
    }
}
