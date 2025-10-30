package com.spring.jdbc.dao;

import com.spring.jdbc.entities.Customer;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RowMapperImpl implements RowMapper<Customer> {
    public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
        Customer customer = new Customer();
        customer.setCid(rs.getString(1));
        customer.setCname(rs.getString(2));
        customer.setBranch(rs.getString(3));
        return customer;
    }
}
