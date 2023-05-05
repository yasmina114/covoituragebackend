package com.example.covoituragebackend.model;

import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document(collection = "Utilisateur")
@TypeAlias("conducteur")
public class Chauffeur extends AppUser {


    private int note;
    private String permis;
  private String cin;
    private String photo;
    private String adress;

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }

    public String getPermis() {
        return permis;
    }

    public void setPermis(String permis) {
        this.permis = permis;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public Chauffeur() {

    }

    public Chauffeur(String id, String confirmedPassword, String email, String username, String password, List<Role> roleList, String firstName, Boolean isPhoneVerified, Date createdAt, String lastName, String tel, String genre, String birthdate, int note, String permis, String cin, String photo, String adress) {
        super(id, confirmedPassword, email, username, password, roleList, firstName, isPhoneVerified, createdAt, lastName, tel, genre, birthdate);
        this.note = note;
        this.permis = permis;
        this.cin = cin;
        this.photo = photo;
        this.adress = adress;
    }

}