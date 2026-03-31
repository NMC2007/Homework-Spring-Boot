package com.example.session3.repository;

import java.util.List;

public interface ICRUDRepo<T> {
    List<T> findAll();
    T findById(int id);
    T create(T data);
    T update(int id, T data);
    T deleteById(int id);
}
