package com.example.covoituragebackend.service;

import com.example.covoituragebackend.dao.ReservationRepository;
import com.example.covoituragebackend.model.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository ;
    public List getAllReservations() {

        List reservations = new ArrayList<>();
        reservationRepository.findAll().forEach(reservations::add);

        return reservations;
    }

    public Reservation getReservation(String id) {
        return reservationRepository.find_id(id);

    }

    public void addReservation(Reservation reservation) {
           reservationRepository.save(reservation);
    }
}
