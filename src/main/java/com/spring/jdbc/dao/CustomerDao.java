package com.spring.jdbc.dao;

import com.spring.jdbc.entities.Customer;

import java.util.List;

public interface CustomerDao {
    public int insertCustomer(Customer customer);
    public int updateCustomer(Customer customer);
    public int deleteCustomer(String cid);
    public Customer getCustomer(String cid);
    public List<Customer> getAllCustomers();
}
