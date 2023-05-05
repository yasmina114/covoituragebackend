package com.example.covoituragebackend.dao;

import com.example.covoituragebackend.model.Reservation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface ReservationRepository extends MongoRepository<Reservation, String> {
    @Query("{'id':?0}")
    Reservation find_id(String id);

    @Query("{'passeger.id':?0}")
    List<Reservation> findbyPassager(String id);
    @Query("{'annonce.id':?0}")
    List<Reservation> findbyAnnonce(String id);

}
