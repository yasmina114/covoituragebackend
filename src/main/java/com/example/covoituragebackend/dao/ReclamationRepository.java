package com.example.covoituragebackend.dao;

import com.example.covoituragebackend.model.Reclamation;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReclamationRepository extends CrudRepository<Reclamation,String> {



    @Query("{'id':?0}")
    Reclamation find_id(String id);
}
