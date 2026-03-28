package com.example.edu.repositories;

import com.example.edu.enums.RoleUser;
import com.example.edu.models.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository implements IBaseRepository<User> {
    private final List<User> usersList = new ArrayList<>();

    public UserRepository() {
        usersList.add(new User(1, "cuong", "cuong@gmail.com", RoleUser.BOSS));
        usersList.add(new User(2, "an", "an@gmail.com", RoleUser.STAFF));
        usersList.add(new User(3, "binh", "binh@gmail.com", RoleUser.STAFF));
        usersList.add(new User(4, "dung", "dung@gmail.com", RoleUser.STAFF));
        usersList.add(new User(5, "linh", "linh@gmail.com", RoleUser.STAFF));
    }

    @Override
    public List<User> findAll() {
        return usersList;
    }

    @Override
    public User findById(int id) {
        return usersList.stream()
                .filter(u -> u.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<User> findByString(String keyword) {
        return usersList.stream()
                .filter(u -> u.getUserName() != null &&
                        u.getUserName().toLowerCase().contains(keyword.toLowerCase()))
                .toList();
    }

    @Override
    public User createData(User data) {
        return null;
    }
}
