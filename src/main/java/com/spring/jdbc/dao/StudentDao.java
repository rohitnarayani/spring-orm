package com.spring.jdbc.dao;

import com.spring.jdbc.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class StudentDao {
    @Autowired
    private HibernateTemplate hibernateTemplate;

    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    @Transactional
    public int insert(Student student) {

        Integer result = (Integer) hibernateTemplate.save(student);

        return result;
    }

    public Student getStudent(Integer id) {
        return this.hibernateTemplate.get(Student.class, id);
    }

    public List<Student> getStudents() {
        return hibernateTemplate.loadAll(Student.class);
    }

    public void deleteStudent(Integer id) {
        Student student = hibernateTemplate.get(Student.class,id);
        if (student != null) {
            hibernateTemplate.delete(student);
            System.out.println("Student deleted successfully");
        }
        else {
            System.out.println("Student not found");
        }

    }

    public void updateStudent(Student student) {
        hibernateTemplate.update(student);
    }
}