package com.example.edu.services;

import java.util.List;

public interface IBaseServices<T> {
    List<T> findAll();
    List<T> findByString(String keyword);
    T createData(T data);
    T findByID(int id);
}
