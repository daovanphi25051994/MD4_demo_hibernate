package com.codegym.repository.customer;

import com.codegym.model.Customer;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class CustomerRepository implements ICustomerRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Customer> getAll() {

        return entityManager.createQuery("SELECT c FROM Customer c").getResultList();
    }

    @Override
    public Customer getById(int id) {
        return entityManager.find(Customer.class, id);
    }

    @Override
    public Customer save(Customer model) {
           if (model.getId() != 0){
               entityManager.merge(model);
           }else {
               entityManager.persist(model);
           }
        return model;
    }

    @Override
    public boolean remove(int id) {
        return false;
    }

    @Override
    public boolean update(int id, Customer model) {
        return false;
    }
}