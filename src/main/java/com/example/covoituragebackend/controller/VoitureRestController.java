package com.example.covoituragebackend.controller;

import com.example.covoituragebackend.dao.ChauffeurRepository;
import com.example.covoituragebackend.dao.MarqueVoitureRepository;
import com.example.covoituragebackend.dao.VoitureRepository;
import com.example.covoituragebackend.model.Voiture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/voitur")
public class VoitureRestController {



    @Autowired
    MarqueVoitureRepository marquevoiturerepository;


    @Autowired
    VoitureRepository voitureRepository;

@Autowired
    ChauffeurRepository  chauffeurRepository;

    @GetMapping("/all")
    public List<Voiture> allvoitur() {
        return voitureRepository.findAll();
    }




    @PostMapping("/add/{idC}/{idM}")
    public Voiture addvoitur(@RequestBody Voiture voiture,@PathVariable String idC,@PathVariable String idM ) {

        voiture.setChauffeur(chauffeurRepository.find_id(idC));
        voiture.setMarqueVoiture(marquevoiturerepository.find_id(idM));
            return this.voitureRepository.save(voiture);

    }




    @PutMapping("/edit/{id}/{idC}/{idM}")
    public Voiture editvoiture (@RequestBody Voiture voiture, @PathVariable String id,@PathVariable String idC ,@PathVariable String idM ) {




            voiture.setId(id);
        voiture.setChauffeur(chauffeurRepository.find_id(idC));
        voiture.setMarqueVoiture(marquevoiturerepository.find_id(idM));
            return voitureRepository.save(voiture);




    }



    @DeleteMapping("/delete/{id}")
    public HashMap deletevoiture(@PathVariable String id) {
        HashMap<String, String> hashMap = new HashMap<>();
        try {
            voitureRepository.deleteById(id);
            hashMap.put("state", "yes");
            return hashMap;
        } catch (Exception e) {
            hashMap.put("state", "no");
            return hashMap;
        }


    }
    @GetMapping("/voiturcond/{idC}")
    public  List<Voiture> getvoiturconducteur (@PathVariable  String idC){
        return voitureRepository.find_voitur(idC);
    }





}






