package com.example.covoituragebackend.controller;

import com.example.covoituragebackend.dao.AdminRepository;
import com.example.covoituragebackend.model.Admin;
import com.example.covoituragebackend.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/admin")
public class AdminRestController {

    @Autowired
    private AccountService accountService;

    @Autowired
    AdminRepository adminRepository;

    @GetMapping("/all")
    public List<Admin> allannonce() {
        return adminRepository.findAll();
    }




    @PostMapping("/add")


    public Admin register(@RequestBody Admin appUser){
        return  accountService.saveAdmin(appUser.getUsername(),appUser.getPassword(),appUser.getConfirmedPassword(),appUser.getFirstName(),appUser.getLastName(),appUser.getTel(),appUser.getGenre(),appUser.getBirthdate(),appUser.getEmail(),appUser.getPhoneVerified());
    }








    @PutMapping("/edit/{id}")
    public Admin editadmin  (@RequestBody Admin admin,  @PathVariable String id) {
        try {



            admin.setId(id);
            return adminRepository.save(admin);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }

    }


    @DeleteMapping("/delete/{id}")
    public HashMap deleteadmin(@PathVariable String id) {
        HashMap<String, String> hashMap = new HashMap<>();
        try {
           adminRepository .deleteById(id);
            hashMap.put("state", "yes");
            return hashMap;
        } catch (Exception e) {
            hashMap.put("state", "no");
            return hashMap;
        }


    }

}



