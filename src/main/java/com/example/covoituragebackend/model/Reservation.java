package com.example.covoituragebackend.model;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.util.Date;

@Document
public class Reservation {
    @Id
    private String id;
    private Number Nbplaces;
    private String etat;
    private Boolean valide;

    public Boolean getValide() {
        return valide;
    }

    public void setValide(Boolean valide) {
        this.valide = valide;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    private Date heure =new Date();

//    LocalTime localTime = LocalTime.now();
    public Reservation() {
    }

    @DBRef
    private Passeger passeger;
    @DBRef
    private Annonce annonce;

    private  Date datevu ;

    public Date getDatevu() {
        return datevu;
    }

    public void setDatevu(Date datevu) {
        this.datevu = datevu;
    }

    public Reservation(String id, Number nbplaces, String etat, Boolean valide, Date heure, Passeger passeger, Annonce annonce, Date datevu) {
        this.id = id;
        Nbplaces = nbplaces;
        this.etat = etat;
        this.valide = valide;
        this.heure = heure;
        this.passeger = passeger;
        this.annonce = annonce;
        this.datevu = datevu;
    }

    public Date getHeure() {
        return heure;
    }

    public void setHeure(Date heure) {
        this.heure = heure;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Number getNbplaces() {
        return Nbplaces;
    }

    public void setNbplaces(Number nbplaces) {
        Nbplaces = nbplaces;
    }


    public Passeger getPasseger() {
        return passeger;
    }

    public void setPasseger(Passeger passeger) {
        this.passeger = passeger;
    }

    public Annonce getAnnonce() {
        return annonce;
    }

    public void setAnnonce(Annonce annonce) {
        this.annonce = annonce;
    }

}