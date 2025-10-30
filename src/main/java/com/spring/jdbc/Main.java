package com.spring.jdbc;

import com.spring.jdbc.dao.CustomerDao;
import com.spring.jdbc.dao.CustomerDaoImpl;
import com.spring.jdbc.entities.Customer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {


       ApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
       CustomerDao customerDao = context.getBean("customerDao",CustomerDaoImpl.class);
       Customer customer = new Customer();
       customer.setCid("C03");
       customer.setCname("Faizan");
       customer.setBranch("Naya vatan");

//       int result = customerDao.insertCustomer(customer);
//       int result = customerDao.updateCustomer(customer);
//       int result = customerDao.deleteCustomer("C01");

//       System.out.println(result+" row inserted");

//         Customer customer2 = customerDao.getCustomer("C02");
//        System.out.println(customer2);

        List<Customer> customers = customerDao.getAllCustomers();

        for (Customer c : customers) {
            System.out.println(c);
        }
    }
}