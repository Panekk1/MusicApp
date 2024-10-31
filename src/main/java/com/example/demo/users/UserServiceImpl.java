package com.example.demo.users;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Component
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public void addNewUser(User user) {
        Optional<User> usersOptional = userRepository.findByemail(user.getEmail());
        if (usersOptional.isPresent()) {
            throw new IllegalArgumentException("User with email " + user.getEmail() + " already exists");
        }
        userRepository.save(user);
    }

    public void deleteUser(Long userId) {
        boolean exists = userRepository.existsById(userId);
        if (!exists) {
            throw new IllegalArgumentException("User with id " + userId + " does not exist");
        }
        userRepository.deleteById(userId);
    }

    @Transactional
    public void updateUser(Long userId, String name, String email) {
        User users = userRepository.findById(userId).orElseThrow(() -> new IllegalStateException("student with id " + userId + "does not exists"));

        if (name != null && name.length() > 0 && !Objects.equals(users.getName(), name)) {
            users.setName(name);
        }

        if(email != null && email.length() > 0 && !Objects.equals(users.getEmail(), email)) {
            Optional<User> usersOptional = userRepository.findByemail(email);
            if (usersOptional.isPresent()) {
                throw new IllegalArgumentException("Email is already in use");
            }
            users.setEmail(email);
        }
    }
}
