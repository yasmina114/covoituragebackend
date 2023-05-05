package com.example.covoituragebackend.dao;

import com.example.covoituragebackend.model.Voiture;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface VoitureRepository extends MongoRepository<Voiture,String> {

    @Query("{'chauffeur.id':?0}")
    List<Voiture> find_voitur(String id);


    @Query("{'id':?0}")
    Voiture find_id(String id);


}
