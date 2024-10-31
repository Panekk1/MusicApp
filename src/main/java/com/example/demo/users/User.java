package com.example.demo.users;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table
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
    private Integer id;
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

    public User(Integer id, String login, String password, String name, String surname, String phone, String adress, String email, Boolean is_admin, String bio, LocalDate registration_date) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.adress = adress;
        this.email = email;
        this.is_admin = is_admin;
        this.bio = bio;
        this.registration_date = registration_date;
    }

    public User(String login, String password, String name, String surname, String phone, String adress, String email, Boolean is_admin, String bio, LocalDate registration_date) {
        this.login = login;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.adress = adress;
        this.email = email;
        this.is_admin = is_admin;
        this.bio = bio;
        this.registration_date = registration_date;
    }

    public Integer getUserId() {
        return id;
    }

    public void setUserId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getAdmin() {
        return is_admin;
    }

    public void setAdmin(Boolean admin) {
        is_admin = admin;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public LocalDate getRegistration_date() {
        return registration_date;
    }

    public void setRegistration_date(LocalDate registrationDate) {
        this.registration_date = registrationDate;
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


