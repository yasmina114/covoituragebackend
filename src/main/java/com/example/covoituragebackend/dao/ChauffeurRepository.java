package com.example.covoituragebackend.dao;

import com.example.covoituragebackend.model.Chauffeur;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChauffeurRepository extends MongoRepository<Chauffeur,String> {
    @Query("{'id':?0}")
Chauffeur find_id(String id);
//
//    @Query("{'username': ?0, 'password': ?1}")
//Chauffeur login(String username, String password);

List <Chauffeur> findChauffeurByUsername();
    Chauffeur findByUsername(String username);
}
