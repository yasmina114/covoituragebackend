package com.example.covoituragebackend.controller;

import com.example.covoituragebackend.dao.*;
import com.example.covoituragebackend.model.Annonce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/annonce")
public class AnnonceRestController {


    @Autowired
    AnnonceRepository annonceRepository;
    @Autowired
    PassegerRepository passegerRepository;
    @Autowired
    VoitureRepository voitureRepository;
    @Autowired
    ReservationRepository reservationRepository;
@Autowired
    ChauffeurRepository chauffeurRepository;
    @GetMapping("/all")
    public List<Annonce> allannonce() {
        return annonceRepository.findAll();
    }




    @PostMapping("/add/{idC}/{idV}")
    public Annonce addannonce(@RequestBody Annonce annonce , @PathVariable String idC ,@PathVariable String idV) {

annonce.setChauffeur(chauffeurRepository.find_id(idC));
annonce.setVoiture(voitureRepository.find_id(idV));
annonce.setCanModify(true);
            return this.annonceRepository.save(annonce);

    }




    @PutMapping("/edit/{id}/{idC}/{idV}")
    public Annonce editannonce  (@RequestBody Annonce annonce,  @PathVariable String id, @PathVariable String idC ,@PathVariable String idV ) {
        Annonce annonce1 = annonceRepository.find_id(id);

        if(reservationRepository.findbyAnnonce(id).size() == 0) {
annonce.setCanModify(true);
           annonce.setChauffeur(chauffeurRepository.find_id(idC));
           annonce.setVoiture(voitureRepository.find_id(idV));
           annonce.setId(id);


           return annonceRepository.save(annonce);
       }
        else{
            annonce1.setCanModify(false);
            System.out.println("you can not edit");
        return annonceRepository.save(annonce1);}

    }

    @GetMapping("/one/{id}")
    public Annonce getOne(@PathVariable String id) {
        return annonceRepository.find_id(id);
    }
//    @DeleteMapping("/delete/{id}")
//    public Chauffeur deletechauffeur(@PathVariable String id){ chauffeurRepository.deleteById(id);
//    return null;}

    @DeleteMapping("/delete/{id}")
    public HashMap deleteannonce(@PathVariable String id) {
        HashMap<String, String> hashMap = new HashMap<>();
        try {
            annonceRepository.deleteById(id);
            hashMap.put("state", "yes");
            return hashMap;
        } catch (Exception e) {
            hashMap.put("state", "no");
         return hashMap;
        }


    }


    @PostMapping("/get/recherchannonce")
    public List<Annonce> getOrdersBySearch(@RequestBody Annonce annonce){
       //return annonceRepository.findAll(Sort.by(lieu_depart, lieu_arrive, date_depart));

        return annonceRepository.getOrdersBySearch(annonce.getLieu_depart(), annonce.getLieu_arrive(), annonce.getDate_depart());
    }

    @PostMapping("/get/recherchannoncenodate")
    public List<Annonce> getOrdersBySearchnodate(@RequestBody Annonce annonce){
        //return annonceRepository.findAll(Sort.by(lieu_depart, lieu_arrive, date_depart));

        return annonceRepository.getannonceBySearchnodate(annonce.getLieu_depart(), annonce.getLieu_arrive());
    }

    @GetMapping("/get/historique/{'idC'}")
    public List<Annonce>gethistorique(String idC){
        return annonceRepository.findbyChauff(idC);
    }
    }









