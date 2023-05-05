package com.example.covoituragebackend.controller;

import com.example.covoituragebackend.dao.MarqueVoitureRepository;
import com.example.covoituragebackend.dao.ModelVoitureRepository;
import com.example.covoituragebackend.model.Modelvoiture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/model")
public class ModelRestController {
    @Autowired
    ModelVoitureRepository modelVoitureRepository;
@Autowired
    MarqueVoitureRepository marqueVoitureRepository;

    @GetMapping("/all")
    public List<Modelvoiture> getall() {


        return (List<Modelvoiture>) modelVoitureRepository.findAll();

    }


    @PostMapping("/add/{idmarque}")
    public Modelvoiture addModelvoiture(@RequestBody Modelvoiture Modelvoiture,@PathVariable String idmarque ) {

        Modelvoiture.setMarqueVoiture(marqueVoitureRepository.find_id(idmarque));
        return this.modelVoitureRepository.save(Modelvoiture);

    }



    @PutMapping("/edit/{id}/{idMarque}")
    public Modelvoiture editModelvoiture  (@RequestBody Modelvoiture Modelvoiture, @PathVariable String id,@PathVariable String idMarque) {




        Modelvoiture.setId(id);
        Modelvoiture.setMarqueVoiture(marqueVoitureRepository.find_id(idMarque));
        return modelVoitureRepository.save(Modelvoiture);




    }



    @GetMapping("/one/{id}")
    public Modelvoiture getOne(@PathVariable  String id){
        return modelVoitureRepository.find_id(id);
    }
    @GetMapping("/modelbymarque/{idMarque}")
    public  List<Modelvoiture> getmodelbymarque (@PathVariable  String idMarque) {
        return modelVoitureRepository.find_modelbymarque(idMarque);
    }
}
