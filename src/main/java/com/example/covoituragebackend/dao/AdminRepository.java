package com.example.covoituragebackend.dao;

import com.example.covoituragebackend.model.Admin;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminRepository extends MongoRepository<Admin,String> {

    Admin findByUsername(String username);
    List<Admin> findChauffeurByIdNotNull();
}
