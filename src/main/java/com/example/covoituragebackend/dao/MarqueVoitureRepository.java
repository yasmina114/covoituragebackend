package com.example.covoituragebackend.dao;

import com.example.covoituragebackend.model.MarqueVoiture;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MarqueVoitureRepository extends MongoRepository<MarqueVoiture,String> {


    @Query("{'id':?0}")
    MarqueVoiture find_id(String id);
}
