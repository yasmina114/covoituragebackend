package com.example.covoituragebackend.dao;

import com.example.covoituragebackend.model.Passeger;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PassegerRepository  extends MongoRepository<Passeger,String> {
    @Query("{'id':?0}")
    Passeger find_id(String id);
//    @Query("{'username': ?0, 'password': ?1}")
//Passeger login(String username, String password);

    Passeger findByUsername(String username);
    List<Passeger> findChauffeurByIdNotNull();
}
