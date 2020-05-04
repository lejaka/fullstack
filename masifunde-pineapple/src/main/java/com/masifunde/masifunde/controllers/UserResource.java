package com.masifunde.masifunde.controllers;

import com.masifunde.masifunde.models.User;
import com.masifunde.masifunde.repository.UserRepository;
import com.masifunde.masifunde.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value="/users")
public class UserResource {
    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @GetMapping
    public List<User> getAll(){
        return userRepository.findAll();
    }

    @PostMapping(value = "/add")
    public List<User> postUser(@RequestBody final User user){
        userRepository.save(user);
        return userRepository.findAll();
    }

    @PostMapping(value = "/user")
    public List<User> getUserbyEmail(@RequestParam String email){
        return userRepository.getByEmail(email);
    }

    @DeleteMapping("/delete/{email}")
    public List<User> deleteUser(@PathVariable String email) {
        User user = new User();
        Integer id=0;

        if(!userRepository.getByEmail(email).isEmpty()){
            List<User> u =userRepository.findAll();

            for(int i=0 ;i<u.size() ; i++)
            {
                String userEmail = u.get(i).getEmail();
                System.out.println(userEmail +" >>> " + email);
                if(email.trim().equals(userEmail))
                {
                    id=u.get(i).getUser_id();
                    System.out.println(id);
                    System.out.println(userEmail +" is the one");
                }
            }

            System.out.println("Email found" + email);

            userRepository.deleteById(id);
        }
        else {
            System.out.println("No email found");
        }
        return userRepository.findAll();
    }

    @PostMapping(value = "/login")
    public Boolean loginByEmail(@RequestBody User userdata){
        Boolean loginStatus;
        if(!userRepository.getByEmail(userdata.getEmail()).isEmpty()){
            List<User> userFromDb = userRepository.getByEmail(userdata.getEmail());
            String dn = userFromDb.get(0).getDisplayName().toLowerCase();
            if(dn.equalsIgnoreCase(userdata.getDisplayName().toLowerCase())){
                loginStatus = true;
            }
            else{
                loginStatus = false;
            }
        }
        else{
            loginStatus = false;
        }
        return loginStatus;
    }

    @PutMapping(value = "/add")
    public ResponseEntity<User> createUpdate(@Valid @RequestBody User user){
        return userService.saveOrUpdate(user);
    }





}

