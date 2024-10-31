package com.example.demo.users;

import java.util.List;

public interface UserService {
    List<User> getUsers();
    void addNewUser(User user);
    void deleteUser(Long userId);
    void updateUser(Long userId, String name, String email);
}