package com.example.covoituragebackend.controller;

import com.example.covoituragebackend.dao.AvisRepository;
import com.example.covoituragebackend.dao.ChauffeurRepository;
import com.example.covoituragebackend.dao.PassegerRepository;
import com.example.covoituragebackend.model.Avis;
import com.example.covoituragebackend.model.Chauffeur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/avis")
public class AvisRestController {
@Autowired
    AvisRepository avisRepository;
    @Autowired
    ChauffeurRepository chauffeurRepository;
    @Autowired
    PassegerRepository passegerRepository;
    @GetMapping("/all")
    public List<Avis> allavis() {
        return avisRepository.findAll();
    }
    @PostMapping("/add/{idC}/{idP}")
    public Avis addavis(@RequestBody Avis avis, @PathVariable String idC,@PathVariable String idP) {

        avis.setChauffeur(chauffeurRepository.find_id(idC));
avis.setPasseger(passegerRepository.find_id(idP));
        return this.avisRepository.save(avis);

    }
    @PostMapping("/addavis/{idC}")
    public Avis addavis(@PathVariable String idC,@RequestBody Avis avis) {

        Chauffeur chauffeur = chauffeurRepository.find_id(idC);

        chauffeur.setId(idC);
        avis.setChauffeur(chauffeur);

        if(chauffeur.getNote()==0){
            chauffeur.setNote(avis.getRaiting());
        }
        chauffeurRepository.save(chauffeur);

        return avisRepository.save(avis);
    }
    @PutMapping("/edit/{id}/{idC}/{idP}")
    public Avis editavis (@RequestBody Avis avis, @PathVariable String id,@PathVariable String idC ,@PathVariable String idP ) {




        avis.setId(id);
        avis.setChauffeur(chauffeurRepository.find_id(idC));
        avis.setPasseger(passegerRepository.find_id(idP));

        return avisRepository.save(avis);




    }
    @DeleteMapping("/delete/{id}")
    public HashMap deleteavis(@PathVariable String id) {
        HashMap<String, String> hashMap = new HashMap<>();
        try {
            avisRepository.deleteById(id);
            hashMap.put("state", "yes");
            return hashMap;
        } catch (Exception e) {
            hashMap.put("state", "no");
            return hashMap;
        }


    }

    @GetMapping("/avisconducteur/{idC}")
    public  List<Avis> getAvisconducteur (@PathVariable  String idC){
        return avisRepository.findAvisByChauffeur(idC);
    }




}
