package com.example.covoituragebackend.controller;

import com.example.covoituragebackend.dao.ChauffeurRepository;
import com.example.covoituragebackend.dao.PassegerRepository;
import com.example.covoituragebackend.dao.ReclamationRepository;
import com.example.covoituragebackend.model.*;
import com.example.covoituragebackend.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/reclamation")
public class ReclamationRestController {


    @Autowired
    private ReclamationRepository reclamationRepository;

    @Autowired
    private ChauffeurRepository chauffeurRepository;

    @Autowired
    private PassegerRepository passegerRepository;

    @Autowired
    private MailService mailService;

    @GetMapping("/all")
    public List<Reclamation> getAll(){
        return (List<Reclamation>) reclamationRepository.findAll();
    }

    @PostMapping("/add/{idU}")
    public Reclamation addreclamation(@RequestBody Reclamation r,@PathVariable String idU)
    {
        for(Chauffeur chauffeur:chauffeurRepository.findAll()) {
            if (chauffeur.getId().equals(idU)) {
                r.setAppUser(chauffeur);
            }
        }

        for(Passeger passeger:passegerRepository.findAll()) {
            if (passeger.getId().equals(idU)) {
                r.setAppUser(passeger);
            }
        }

        return this.reclamationRepository.save(r);
    }
    @PutMapping("/update/{id}/{idU}")

    public Reclamation updatereclamtion(@RequestBody Reclamation r, @PathVariable  String id, @PathVariable String idU){
        r.setId(id);
        for(Chauffeur chauffeur:chauffeurRepository.findAll()) {
            if (chauffeur.getId().equals(idU)) {
                r.setAppUser(chauffeur);
            }
        }

        for(Passeger passeger:passegerRepository.findAll()) {
            if (passeger.getId().equals(idU)) {
                r.setAppUser(passeger);
            }
        }

        return reclamationRepository.save(r);}

    @GetMapping("/reponse/{id}")
    public Response reponse (@PathVariable String id){
        Response rs= new Response();
        try {
            Reclamation reclamation;
            reclamation = reclamationRepository.find_id(id);
            reclamation.setReponseRec(true);
            reclamationRepository.save(reclamation);
            rs.setState("ok");
            return rs;
        }
        catch (Exception e){
            rs.setState("non");
            return rs;
        }
    }

    @DeleteMapping("/delete/{id}")
    public Response deleteUser(@PathVariable String id){

        Response res = new Response();
        System.out.println("id=" +id);
        try {
            reclamationRepository.deleteById(id);
            res.setState("ok");
        }catch (Exception e){
            System.out.println(e.getMessage());
            res.setState("non");
        }
        return res ;
    }
    @GetMapping("/one/{id}")
    public Reclamation getOne(@PathVariable  String id){

        return reclamationRepository.find_id(id);
    }

    @PostMapping(value="/sendMail/{idreclamation}")
    public Response sendMail(@RequestBody Mail mail,@PathVariable String idreclamation)


    {
        Response rs=new Response();


        System.out.println("Spring Mail - Sending Simple Email with JavaMailSender Example");

        mail.setFrom("rimesbenabdallh@gmail.com");
        mail.setTo(mail.getTo());
        mail.setSubject("Reponse pour votre Reclamation");
        mail.setContent(mail.getContent());
        mailService.sendSimpleMessage(mail);



        rs.setState("email ok");
        return rs;

    }

}
