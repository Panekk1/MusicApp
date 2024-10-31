package com.example.demo.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/user")
public class UserController {

    private final UserService usersServices;

    @Autowired
    public UserController(UserService usersServices) {
        this.usersServices = usersServices;
    }

    @GetMapping
    public List<User> getUsers() {
        return usersServices.getUsers();
    }

    @PostMapping
    public void registerUser(@RequestBody User user) {
        usersServices.addNewUser(user);
    }

    @DeleteMapping(path = "{id}")
    public void deleteUser(@PathVariable("id") Long id) {
        usersServices.deleteUser(id);
    }

    @PutMapping(path = "{id}")
    public void updateUser(@PathVariable("id") Long id, @RequestParam(required = false) String name, @RequestParam(required = false) String email) {
        usersServices.updateUser(id, name, email);
    }
}
