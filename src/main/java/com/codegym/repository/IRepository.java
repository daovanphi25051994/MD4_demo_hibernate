package com.codegym.repository;

import java.util.List;

public interface IRepository<T> {
    List<T> getAll();
    T getById(int id);
    T save(T model);
    boolean remove(int id);
    boolean update(int id, T model);
}
