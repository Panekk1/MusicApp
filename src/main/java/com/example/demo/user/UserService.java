package com.example.demo.user;

import java.util.List;

public interface UserService {
    List<User> getUsers();
    void addUser(User user);
    void deleteUser(Long id);
    User updateUser(Long id, User userUpdates);
}
