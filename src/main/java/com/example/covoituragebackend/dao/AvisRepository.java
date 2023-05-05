package com.example.covoituragebackend.dao;

import com.example.covoituragebackend.model.Avis;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AvisRepository extends MongoRepository<Avis,String> {
    @Query("{'chauffeur.id':?0}")
    List<Avis> findAvisByChauffeur(String id);
    @Query("{'passager.id':?0}")
    List<Avis> findAvisBypassager(String id);
}
