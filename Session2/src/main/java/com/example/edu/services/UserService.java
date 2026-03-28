package com.example.edu.services;

import com.example.edu.models.User;
import com.example.edu.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService implements IBaseServices<User> {
    private final UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public List<User> findByString(String keyword) {
        return userRepository.findByString(keyword);
    }

    @Override
    public User createData(User data) {
        return null;
    }

    @Override
    public User findByID(int id) {
        return userRepository.findById(id);
    }
}
