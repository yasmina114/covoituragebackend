package com.example.covoituragebackend.controller;

import com.example.covoituragebackend.dao.UserRepository;
import com.example.covoituragebackend.model.*;
import com.example.covoituragebackend.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/user")
public class UserRestController {
  @Autowired
  private UserRepository userRepository;
    @Autowired
    private AccountService accountService;


//    public Optional findUserByEmail(String email) {
//        return userRepository.findByEmail(email);
//    }
//
//
//    public Optional findUserByResetToken(String resetToken) {
//        return userRepository.findByResetToken(resetToken);
//    }

    @PostMapping("/register")
    public AppUser register(@RequestBody AppUser appUser){
        return (AppUser) accountService.saveAdmin(appUser.getUsername(),appUser.getPassword(),appUser.getConfirmedPassword(),appUser.getFirstName(),appUser.getLastName(),appUser.getTel(),appUser.getGenre(),appUser.getBirthdate(),appUser.getEmail(),appUser.getPhoneVerified());
//
//    @PostMapping("/registerpassager")
//    public Passeger register(@RequestBody Passeger appUser){
//        return  accountService.savePassager(appUser.getUsername(),appUser.getPassword(),appUser.getConfirmedPassword(),appUser.getFirstName(),appUser.getLastName(),appUser.getTel(),appUser.getSexe(),appUser.getEmail());
//    }
//
//    @PostMapping("/addconducteur")
//    public Chauffeur ajouterconducteur(String confirmedPassword, String email, String firstName, String lastName, String tel,
//                                       String username, String password, String ville, String sexe,
//                                       String permis, String cin, String photo, String adress, String age) {
//
//
//
//        return this.accountService.saveChaufeur( confirmedPassword, email, firstName, lastName,tel,
//                username, password, ville,sexe,
//                permis, cin, photo, adress,age);
//
//
//
//
//
//    }
//
//    @PostMapping("/addadmin")
//    public Admin addnewadmin(String username, String password, String confirmedPassword, String firstName, String lastName, String tel, String sexe, String email) {
//
//
//
//
//
//        return this.accountService.saveAdmin(username,password, confirmedPassword,firstName, lastName,tel, sexe, email);
//
//
   }





    @GetMapping("/all")
  public List<AppUser> getAll(){
    return (List<AppUser>) userRepository.findAll();
  }

  @PutMapping("/update/{id}")
  public AppUser updateUser(@RequestBody AppUser user, @PathVariable  String id){
    user.setId(id);
    return userRepository.save(user);

  }
  @DeleteMapping("/delete/{id}")
public Response deleteUser(@PathVariable String id){

      Response res = new Response();
    System.out.println("id=" +id);
    try {
      userRepository.deleteById(id);
      res.setState("ok");
    }catch (Exception e){
      System.out.println(e.getMessage());
      res.setState("non");
    }
    return res ;
}
@GetMapping("/byiduser/{id}")
    public AppUser  getUser(@PathVariable String id){
    AppUser appUser = userRepository.find_id(id);
    return appUser ;
}

//@PostMapping("/loogin")
//  public AppUser login(@RequestBody AppUser user) {
//
//  return userRepository.login(user.getUsername(), user.getPassword());
//
//}
}



