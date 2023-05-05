package com.example.covoituragebackend.model;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.util.Date;

@Document
public class Voiture {
    @Id
    private String id;


    private String model;
    private String plaque_imatriculation;
    private Date date_imatriculation;
    private String type;
    private String couleur;

    public Chauffeur getChauffeur() {
        return chauffeur;
    }

    public void setChauffeur(Chauffeur chauffeur) {
        this.chauffeur = chauffeur;
    }
    @DBRef
    private MarqueVoiture marqueVoiture;



    @DBRef
    private Chauffeur chauffeur;
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }




    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getPlaque_imatriculation() {
        return plaque_imatriculation;
    }

    public void setPlaque_imatriculation(String plaque_imatriculation) {
        this.plaque_imatriculation = plaque_imatriculation;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public Date getDate_imatriculation() {
        return date_imatriculation;
    }

    public void setDate_imatriculation(Date date_imatriculation) {
        this.date_imatriculation = date_imatriculation;
    }
    public MarqueVoiture getMarqueVoiture() {
        return marqueVoiture;
    }

    public void setMarqueVoiture(MarqueVoiture marqueVoiture) {
        this.marqueVoiture = marqueVoiture;
    }
}
