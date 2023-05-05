package com.example.covoituragebackend.dao;

import com.example.covoituragebackend.model.Modelvoiture;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModelVoitureRepository extends MongoRepository<Modelvoiture,String> {
    @Query("{'id':?0}")
    Modelvoiture find_id(String id);
    @Query("{'marqueVoiture.id':?0}")
    List<Modelvoiture> find_modelbymarque(String id);
}
