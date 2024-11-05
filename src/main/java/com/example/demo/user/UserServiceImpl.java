package com.example.demo.user;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
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
        return (List<User>) userRepository.findAll();
    }

    public void addUser(User user) {
        Optional<User> userOptionalEmail = userRepository.findByEmail(user.getEmail());
        Optional<User> userOptionalLogin = userRepository.findByLogin(user.getLogin());
        if (userOptionalEmail.isPresent()) {
            throw new IllegalArgumentException("User with email " + user.getEmail() + " already exists");
        }
        if (userOptionalLogin.isPresent()) {
            throw new IllegalArgumentException("User with login " + user.getLogin() + " already exists");
        }
        user.setRegistration_date(LocalDate.now());
        userRepository.save(user);
    }

    public void deleteUser(Long id) {
        boolean exists = userRepository.existsById(id);
        if (!exists) {
            throw new IllegalArgumentException("User does not exist");
        }
        userRepository.deleteById(id);
    }


    @Transactional
    public User updateUser(Long id, User userUpdates) {
        User user = userRepository.findById(id).orElseThrow(() -> new IllegalStateException("User does not exist"));

        if (!Objects.equals(userUpdates.getLogin(), user.getLogin())) {
            user.setLogin(userUpdates.getLogin());
        }

        if (!Objects.equals(userUpdates.getPassword(), user.getPassword())) {
            user.setPassword(userUpdates.getPassword());
        }

        if (userUpdates.getName() != null && !userUpdates.getName().isEmpty() &&
                !Objects.equals(user.getName(), userUpdates.getName())) {
            user.setName(userUpdates.getName());
        }

        if (!Objects.equals(userUpdates.getSurname(), user.getSurname())) {
            user.setSurname(userUpdates.getSurname());
        }

        if (!Objects.equals(userUpdates.getPhone(), user.getPhone())) {
            user.setPhone(userUpdates.getPhone());
        }

        if (!Objects.equals(userUpdates.getAdress(), user.getAdress())) {
            user.setAdress(userUpdates.getAdress());
        }

        if (userUpdates.getEmail() != null && !userUpdates.getEmail().isEmpty() &&
                !Objects.equals(user.getEmail(), userUpdates.getEmail())) {
            Optional<User> userOptional = userRepository.findByEmail(userUpdates.getEmail());
            if (userOptional.isPresent()) {
                throw new IllegalArgumentException("Email is already in use");
            }
            user.setEmail(userUpdates.getEmail());
        }

        if (userUpdates.getIs_admin() != null) {
            user.setIs_admin(userUpdates.getIs_admin());
        }

        if (userUpdates.getBio() != null && !userUpdates.getBio().isEmpty()) {
            user.setBio(userUpdates.getBio());
        }

        return userRepository.save(user);
    }

}
