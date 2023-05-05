package com.example.covoituragebackend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class MarqueVoiture {
    @Id
    private String id;
    private String nom;
    private String logo;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getLogo() {
        return logo;
    }

    public void setPhoto(String photo) {
        this.logo = photo;
    }

    public MarqueVoiture() {
    }

    public MarqueVoiture(String id, String nom, String photo) {
        this.id = id;
        this.nom = nom;
        this.logo = photo;
    }
}
