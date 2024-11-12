package com.example.demo.user;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter

@Entity
@Table(name = "users")
public class User {
    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )



    private int id;
    private String login;
    private String password;
    private String name;
    private String surname;
    private String phone;
    private String adress;
    private String email;
    private Boolean is_admin;
    private String bio;
    private LocalDate registration_date;

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", phone='" + phone + '\'' +
                ", adress='" + adress + '\'' +
                ", email='" + email + '\'' +
                ", isAdmin=" + is_admin +
                ", bio='" + bio + '\'' +
                ", registrationDate=" + registration_date +
                '}';
    }
}
