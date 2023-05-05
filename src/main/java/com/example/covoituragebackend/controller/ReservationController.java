package com.example.covoituragebackend.controller;

import com.example.covoituragebackend.dao.AnnonceRepository;
import com.example.covoituragebackend.dao.ChauffeurRepository;
import com.example.covoituragebackend.dao.PassegerRepository;
import com.example.covoituragebackend.dao.ReservationRepository;
import com.example.covoituragebackend.model.Annonce;
import com.example.covoituragebackend.model.Reservation;
import com.example.covoituragebackend.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/res")

public class ReservationController {

    @Autowired
    private ReservationService reservationService;
    @Autowired
    private ChauffeurRepository chauffeurRepository;
    @Autowired
    private AnnonceRepository annonceRepository;
    @Autowired
    private PassegerRepository passegerRepository;
    @Autowired
    private ReservationRepository reservationRepository;


    @GetMapping("/reservations")
    public List getAllReservations() {

        return reservationService.getAllReservations();
    }

    @GetMapping("/validerreservation/{id}")
    public Reservation validerReservation(@PathVariable String id) {
        Reservation reservation = reservationRepository.find_id(id);


        reservation.setEtat("accepter");
        reservation.setDatevu(new Date());

        return reservationRepository.save(reservation);
    }

    @GetMapping("/refusereservation/{id}")
    public Reservation refuseReservation(@PathVariable String id) {
        Reservation reservation = reservationRepository.find_id(id);

        reservation.setEtat("refuser");
        reservation.setDatevu(new Date());
        return reservationRepository.save(reservation);
    }

    @GetMapping("/annullerreservation/{id}")
    public Reservation annullerreservation(@PathVariable String id) {
        Reservation reservation = reservationRepository.find_id(id);

        reservation.setEtat("annuler");
        reservation.setDatevu(new Date());
        return reservationRepository.save(reservation);
    }


    @GetMapping("/resrvationpassager/{idP}")
    public List<Reservation> getReservationbyidpassager(@PathVariable String idP) {


        return reservationRepository.findbyPassager(idP);


    }

    @GetMapping("/resrvationaccepter/{idP}")
    public List<Reservation> getReservationaccepterbyidpassager(@PathVariable String idP) {

        List<Reservation> reservations = new ArrayList<>();
        for (Reservation reservation : reservationRepository.findbyPassager(idP)) {
            if (reservation.getEtat().equals("accepter")) {
                reservations.add(reservation);
            }
        }
        return reservations;

    }

    @GetMapping("/reservationrefuser/{idP}")
    public List<Reservation> Resrefuserbyidpass(@PathVariable String idP) {

        List<Reservation> reservations = new ArrayList<>();
        for (Reservation reservation : reservationRepository.findbyPassager(idP)) {
            if (reservation.getEtat().equals("refuser")) {
                reservations.add(reservation);
            }
        }
        return reservations;

    }

    @GetMapping("/reservationenattendpassger/{idpassager}")
    public List<Reservation> getReservatiionattend(@PathVariable String idpassager) {

        List<Reservation> reservations = new ArrayList<>();
        for (Reservation reservation : reservationRepository.findbyPassager(idpassager)) {
            if (reservation.getEtat().equals("enattend")) {
                reservations.add(reservation);
            }

        }
        return reservations;
    }

    @GetMapping("/reservationenattend/{idconducteur}")
    public List<Reservation> getReservationrejeter(@PathVariable String idconducteur) {

        List<Reservation> reservations = new ArrayList<>();
        for (Reservation reservation : reservationRepository.findAll()) {
            if (reservation.getEtat().equals("enattend") && reservation.getAnnonce().getChauffeur().getId().equals(idconducteur)) {
                reservations.add(reservation);
            }
        }

        return reservations;
    }


    @GetMapping("/reservations/{id}")
    public Reservation getReservation(@PathVariable String id) {
        return reservationService.getReservation(id);
    }

//        @PostMapping("/addreservation/{idPas}/{idC}")
//        public Reservation addReservation(@RequestBody Reservation reservation, @PathVariable String idPas,@PathVariable String idC ) {
//
//            reservation.setAnnonce(annonceRepository.find_id(idC));
//            reservation.setPasseger(passegerRepository.find_id(idPas));
//              reservation.setEtat(false);
//
//            return reservationRepository.save(reservation);
//
//    }

    @PostMapping("/limitreservation/{idPas}/{idannonce}")
    public Reservation ajoutReservation(@RequestBody Reservation reservation, @PathVariable String idPas, @PathVariable String idannonce) {
        Annonce a = annonceRepository.find_id(idannonce);
        reservation.setAnnonce(annonceRepository.find_id(idannonce));
        reservation.setPasseger(passegerRepository.find_id(idPas));
        reservation.setValide(true);
        a.setNbrplacesdisponible(a.getNbrplacesdisponible().intValue() - reservation.getNbplaces().intValue());
        annonceRepository.save(a);
        return reservationRepository.save(reservation);

    }

    @GetMapping("/allnonvalid")
    public List<Reservation> gettalnonvalide() {
        List<Reservation> reservationList = new ArrayList<>();
        for (Reservation reservation : reservationRepository.findAll())
            if (!reservation.getValide())
                reservationList.add(reservation);
        return reservationList;
    }

    @DeleteMapping("supp")
    public HashMap suppnonvalid() {
        HashMap<String, String> hashMap = new HashMap<>();

        try {
            List<Reservation> reservations = gettalnonvalide();
            for (int i = 0; i < reservations.size(); i++)

                reservationRepository.deleteById(reservations.get(i).getId());
            hashMap.put("state", "yes");
            return hashMap;
        } catch (Exception e) {
            hashMap.put("state", "no");
            return hashMap;
        }
    }

    @DeleteMapping("/deleteresrvation/{id}")
    public HashMap deletereservation(@PathVariable String id) {
        HashMap<String, String> hashMap = new HashMap<>();
        try {
            reservationRepository.deleteById(id);
            hashMap.put("state", "yes");
            return hashMap;
        } catch (Exception e) {
            hashMap.put("state", "no");
            return hashMap;
        }


    }

    @GetMapping("/historique/{idP}")
    public List<Reservation> gethistoriquepassager(@PathVariable String idP) {


        return reservationRepository.findbyPassager(idP);
    }


}
