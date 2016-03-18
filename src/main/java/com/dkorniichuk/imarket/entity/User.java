package com.dkorniichuk.imarket.entity;

import java.util.Date;
import java.util.List;

public class User {
    private int id;
    private String login;
    private String firstName;
    private String secondName;
    private String email;
    private String password;
    private String address;
    private String city;
    private String phone;
    private Date registrationDate;
    private UserRole role;
    private List<Product> bucket;

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getRole() {
        return role.name();
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public List<Product> getBucket() {
        return bucket;
    }

    public void setBucket(List<Product> bucket) {
        this.bucket = bucket;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", phone='" + phone + '\'' +
                ", registrationDate=" + registrationDate +
                ", role=" + role +
                ", bucket=" + bucket +
                '}';
    }
}
