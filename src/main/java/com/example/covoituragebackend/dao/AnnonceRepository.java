package com.example.covoituragebackend.dao;

import com.example.covoituragebackend.model.Annonce;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface AnnonceRepository  extends MongoRepository<Annonce,String> {




    @Query("{'id':?0}")
    Annonce find_id(String id);







    @Query("{'chauffeur.id':?0}")
    List<Annonce> findbyChauff(String id);

    @Query("{'lieu_depart': ?0, 'lieu_arrive': ?1, 'date_depart': ?2}")
    List<Annonce> getOrdersBySearch(String lieu_depart, String lieu_arrive, String date_depart);

    @Query("{'lieu_depart': ?0, 'lieu_arrive': ?1}")
    List<Annonce> getannonceBySearchnodate(String lieu_depart, String lieu_arrive);


}
