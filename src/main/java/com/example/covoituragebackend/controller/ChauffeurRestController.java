package com.example.covoituragebackend.controller;

import com.example.covoituragebackend.dao.*;
import com.example.covoituragebackend.model.*;
import com.example.covoituragebackend.service.AccountService;
import com.example.covoituragebackend.utils.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/chauffeur")
public class ChauffeurRestController {
    @Autowired
    ChauffeurRepository chauffeurRepository;

    @Autowired
    AnnonceRepository annonceRepository;

    @Autowired
    AvisRepository avisRepository;

    @Autowired
    UserRepository userRepository;
    @Autowired
    private AccountService accountService;
    @Autowired
    private PassegerRepository passegerRepository;
    @Autowired
    private StorageService storageService;
//    @GetMapping("/all")
//    public List<Chauffeur> getAll() {
//        return chauffeurRepository.findAll();
//    }

    @GetMapping("/all")
    public List<Chauffeur> getall() {


        return (List<Chauffeur>) chauffeurRepository.findAll();

    }


    @PostMapping("/add")
    public Chauffeur register(@RequestBody Chauffeur appUser) {

        return accountService.saveChaufeur(appUser.getConfirmedPassword(), appUser.getEmail(), appUser.getFirstName(), appUser.getLastName(), appUser.getTel(), appUser.getUsername(), appUser.getPassword(), appUser.getGenre(), appUser.getBirthdate(), appUser.getPermis(), appUser.getCin(), appUser.getPhoto(), appUser.getAdress(), appUser.getPhoneVerified());
    }
//        @PostMapping("/login")
//        public HashMap<String,AppUser> login(@RequestBody AppUser chaufeur) {
//        HashMap<String,AppUser> hashMap=new HashMap<>();
//        try {
//
//            System.out.println(chaufeur.getUsername());
//            System.out.println(chaufeur.getPassword());
//
//            hashMap.put("data",chauffeurRepository.login(chaufeur.getUsername(), chaufeur.getPassword()));
//        }
//        catch (Exception e){
//          hashMap.put("data",null);
//        }
//
//return  hashMap;
//        }

    @PutMapping("/edit/{id}")

    public Chauffeur editchaufeur(@RequestBody Chauffeur personnel, @PathVariable String id) {

        Chauffeur client1 = chauffeurRepository.find_id(id);
        personnel.setId(id);


        personnel.setUsername(client1.getUsername());
        personnel.setPassword(client1.getPassword());
        personnel.setConfirmedPassword(client1.getConfirmedPassword());
        personnel.setRoleList(client1.getRoleList());

        return chauffeurRepository.save(personnel);

    }

//    @PutMapping("/edit/{id}")
//    public Chauffeur editchaufeur  (@RequestBody Chauffeur chauffeur,  @PathVariable String id) {
//
//
//        chauffeur.setId(id);
//        return accountService.editChaufeur(chauffeur.getEmail(), chauffeur.getLastName(), chauffeur.getTel(), chauffeur.getUsername(), chauffeur.getGenre(), chauffeur.getBirthdate(), chauffeur.getPermis(), chauffeur.getCin(), chauffeur.getPhoto(), chauffeur.getAdress());
//    }

    @GetMapping("/one/{id}")
    public Chauffeur getOne(@PathVariable String id) {

        return chauffeurRepository.find_id(id);
    }

    @GetMapping("/getuser/{username}")
    public Chauffeur getbyusername(@PathVariable String username) {

        return chauffeurRepository.findByUsername(username);
    }
//    @DeleteMapping("/delete/{id}")
//    public Chauffeur deletechauffeur(@PathVariable String id){ chauffeurRepository.deleteById(id);
//    return null;}

    @DeleteMapping("/delete/{id}")
    public HashMap deleteconducteur(@PathVariable String id) {
        HashMap<String, String> hashMap = new HashMap<>();
        try {
            chauffeurRepository.deleteById(id);
            hashMap.put("state", "yes");
            return hashMap;
        } catch (Exception e) {
            hashMap.put("state", "no");
            return hashMap;
        }


    }


    @GetMapping("/allchauffAnnonce")
    public List<Chauffeur> getAllChauff() {
        List<Chauffeur> chauffeurs = new ArrayList<>();
        for (Chauffeur chauffeur : chauffeurRepository.findAll()) {
            System.out.println(chauffeurRepository.findAll());
            List<Annonce> l = annonceRepository.findbyChauff(chauffeur.getId());
            if (l.size() > 1) {
                chauffeurs.add(chauffeur);

            }
        }


        return chauffeurs;
    }

    @GetMapping("/allAnnoncebyxhaufeur/{idchauf}")
    public List<Annonce> getAnnoncebychaufeyr(@PathVariable String idchauf) {

        List<Annonce> l = annonceRepository.findbyChauff(idchauf);


        return l;

    }

    //    @GetMapping("/like/{id}/{note}")
//    public Chauffeur getlike(@PathVariable String id,@PathVariable Integer note) {
//
//       Chauffeur chauffeur=chauffeurRepository.find_id(id);
//       chauffeur.setNote(note);
//       chauffeurRepository.save(chauffeur);
//       return chauffeur;
//
//    }
//@PostMapping("/addavis/{idC}")
//public Avis addavis(@PathVariable String idC,@RequestBody Avis avis) {
//
//        Chauffeur chauffeur = chauffeurRepository.find_id(idC);
//
//    chauffeur.setId(idC);
//    avis.setChauffeur(chauffeur);
//
//if(chauffeur.getNote()==0){
//            chauffeur.setNote(avis.getRaiting());
//        }
//        chauffeurRepository.save(chauffeur);
//
//       return avisRepository.save(avis);
//}
    @GetMapping("/lisetavis/{id}")
    public Chauffeur avischaufeur(@PathVariable String id) {
        List<Avis> avisList = avisRepository.findAvisByChauffeur(id);
        int nb = avisList.size();
        int somme = 0;
        int notes = 0;

        for (Avis avis : avisRepository.findAvisByChauffeur(id)) {
            somme = somme + avis.getRaiting();

        }
        notes = somme / nb;
        Chauffeur chauffeur = chauffeurRepository.find_id(id);
        chauffeur.setNote(notes);
        return chauffeurRepository.save(chauffeur);
    }

}




