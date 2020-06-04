package com.codegym.service;

import com.codegym.model.Customer;

import java.util.List;

public interface IService<T> {
    List<T> findAll();

    T findById(int id);

    T save(T model);

    List<T> save(List<T> models);

    boolean exists(int id);

    List<T> findAll(List<Integer> ids);

    int count();

    boolean deleteById(int id);

    boolean deleteByModel(T model);

    boolean delete(List<T> models);

    boolean deleteAll();
}
