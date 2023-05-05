package com.example.covoituragebackend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

public class Avis {
    @Id
    private String id;

    private int raiting;
    @DBRef
    private Chauffeur chauffeur;
    @DBRef
    private Passeger passeger;

    public Passeger getPasseger() {
        return passeger;
    }

    public void setPasseger(Passeger passeger) {
        this.passeger = passeger;
    }

    public Avis() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public int getRaiting() {
        return raiting;
    }

    public void setRaiting(int raiting) {
        this.raiting = raiting;
    }

    public Chauffeur getChauffeur() {
        return chauffeur;
    }

    public void setChauffeur(Chauffeur chauffeur) {
        this.chauffeur = chauffeur;
    }

    public Avis(String id, int raiting, Chauffeur chauffeur, Passeger passeger) {
        this.id = id;
        this.raiting = raiting;
        this.chauffeur = chauffeur;
        this.passeger = passeger;
    }
}


