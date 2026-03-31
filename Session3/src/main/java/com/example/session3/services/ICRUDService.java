package com.example.session3.services;

import java.util.List;

public interface ICRUDService<T> {
    List<T> getAll();
    T getById(int id);
    T create(T data);
    T update(int id, T data);
    T delete(int id);
}
