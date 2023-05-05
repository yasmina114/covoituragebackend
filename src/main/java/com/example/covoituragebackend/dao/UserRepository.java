package com.example.covoituragebackend.dao;

import com.example.covoituragebackend.model.AppUser;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<AppUser,String> {
    @Query("{'id':?0}")
    AppUser find_id(String id);

    AppUser findByUsername(String username);

    @Query("{'username': ?0, 'password': ?1}")
    AppUser login(String username, String password);

}