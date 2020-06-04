package com.codegym.service.customer;

import com.codegym.model.Customer;
import com.codegym.repository.customer.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    public List<Customer> findAll() {
        return customerRepository.getAll();
    }

    @Override
    public Customer findById(int id) {
        return customerRepository.getById(id);
    }

    @Override
    public Customer save(Customer model) {
        return customerRepository.save(model);
    }

    @Override
    public List<Customer> save(List<Customer> models) {
        return null;
    }

    @Override
    public boolean exists(int id) {
        return false;
    }

    @Override
    public List<Customer> findAll(List<Integer> ids) {
        return null;
    }

    @Override
    public int count() {
        return 0;
    }

    @Override
    public boolean deleteById(int id) {
        return false;
    }

    @Override
    public boolean deleteByModel(Customer model) {
        return false;
    }

    @Override
    public boolean delete(List<Customer> models) {
        return false;
    }

    @Override
    public boolean deleteAll() {
        return false;
    }
}