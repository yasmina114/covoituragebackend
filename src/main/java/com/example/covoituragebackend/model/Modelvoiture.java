package com.example.covoituragebackend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Modelvoiture {
    @Id
    private String id;
    private String nom;
@DBRef
private MarqueVoiture marqueVoiture;

    public MarqueVoiture getMarqueVoiture() {
        return marqueVoiture;
    }

    public void setMarqueVoiture(MarqueVoiture marqueVoiture) {
        this.marqueVoiture = marqueVoiture;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public Modelvoiture() {
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Modelvoiture(String id, String nom, MarqueVoiture marqueVoiture) {
        this.id = id;
        this.nom = nom;
        this.marqueVoiture = marqueVoiture;
    }
}
