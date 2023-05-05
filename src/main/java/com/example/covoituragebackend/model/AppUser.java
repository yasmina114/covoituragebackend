package com.example.covoituragebackend.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;


import javax.persistence.Column;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Document(collection = "Utilisateur")
@Component
public  class  AppUser {
    @Id
    private String id;
    private String confirmedPassword;
    //private String resetToken;

//    public String getResetToken() {
//        return resetToken;
//    }
//
//    public void setResetToken(String resetToken) {
//        this.resetToken = resetToken;
//    }


    public AppUser(String id, String confirmedPassword, String email, String username, String password, List<Role> roleList, String firstName, Boolean isPhoneVerified, Date createdAt, String lastName, String tel, String genre, String birthdate) {
        this.id = id;
        this.confirmedPassword = confirmedPassword;
        this.email = email;
        this.username = username;
        this.password = password;
        this.roleList = roleList;
        this.firstName = firstName;
        this.isPhoneVerified = isPhoneVerified;
        this.createdAt = createdAt;
        this.lastName = lastName;
        this.tel = tel;
        this.genre = genre;
        this.birthdate = birthdate;
    }

    private String email;
    @Column(unique = true)
    private String username;
    @JsonProperty(access = JsonProperty.Access.READ_WRITE)
    private String password;
    @DBRef
    private List<Role> roleList = new ArrayList<>();

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public AppUser(){

    }

    private String firstName;
    private Boolean isPhoneVerified;

    public Boolean getPhoneVerified() {
        return isPhoneVerified;
    }

    public void setPhoneVerified(Boolean phoneVerified) {
        isPhoneVerified = phoneVerified;
    }

    private Date createdAt = new Date();

    private String lastName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getConfirmedPassword() {
        return confirmedPassword;
    }

    public void setConfirmedPassword(String confirmedPassword) {
        this.confirmedPassword = confirmedPassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    private String tel;


    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }


    private String genre;
    private String  birthdate;

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }
}