package com.example.covoituragebackend.model;

import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document(collection = "Utilisateur")
@TypeAlias("admin")
public class Admin extends AppUser {
    public Admin() {

    }

    public Admin(String id, String confirmedPassword, String email, String username, String password, List<Role> roleList, String firstName, Boolean isPhoneVerified, Date createdAt, String lastName, String tel, String genre, String birthdate) {
        super(id, confirmedPassword, email, username, password, roleList, firstName, isPhoneVerified, createdAt, lastName, tel, genre, birthdate);
    }
}
