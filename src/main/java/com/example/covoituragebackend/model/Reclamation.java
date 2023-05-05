package com.example.covoituragebackend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Reclamation {


    @Id
    private String id;
    private String titre;
    private String sujet;
    private Boolean reponseRec = false;

    public Boolean getReponseRec() {
        return reponseRec;
    }

    public void setReponseRec(Boolean reponseRec) {
        this.reponseRec = reponseRec;
    }

    public Reclamation() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSujet() {
        return sujet;
    }

    public void setSujet(String sujet) {
        this.sujet = sujet;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public Reclamation(String id, String titre, String sujet, Boolean reponseRec, AppUser appUser) {
        this.id = id;
        this.titre = titre;
        this.sujet = sujet;
        this.reponseRec = reponseRec;
        this.appUser = appUser;
    }

    @DBRef
    private AppUser appUser;

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }
}
