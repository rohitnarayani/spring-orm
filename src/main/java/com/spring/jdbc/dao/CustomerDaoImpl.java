package com.spring.jdbc.dao;

import com.spring.jdbc.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("customerDao")
public class CustomerDaoImpl implements CustomerDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertCustomer(Customer customer) {
        String query = "insert into customer values(?,?,?)";

        int result = jdbcTemplate.update(query,customer.getCid(),customer.getCname(),customer.getBranch());
        return result;
    }

    public int updateCustomer(Customer customer) {
        String query = "update customer set cname=?,branch=? where cid=?";

        int result = jdbcTemplate.update(query,customer.getCname(),customer.getBranch(),customer.getCid());
        return result;
    }

    public int deleteCustomer(String id) {
        String query = "delete from customer where cid=?";

        int result = jdbcTemplate.update(query,id);

        return result;
    }

    @Override
    public Customer getCustomer(String cid) {
        String query = "select * from customer where cid=?";
        RowMapper<Customer> rowMapper = new RowMapperImpl();
        Customer customer = jdbcTemplate.queryForObject(query,rowMapper,cid);

        return customer;
    }

    @Override
    public List<Customer> getAllCustomers() {
        String query = "select * from customer";
        RowMapper<Customer> rowMapper = new RowMapperImpl();

        List<Customer> customers = jdbcTemplate.query(query,rowMapper);

        return customers;
    }
}
