package com.example.edu.repositories;

import com.example.edu.models.User;

import java.util.List;

public interface IBaseRepository<T> {
    List<T> findAll();
    List<T> findByString(String keyword);
    T findById(int id);
    T createData(T data);
}
