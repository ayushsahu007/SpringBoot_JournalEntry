package net.engineeringdigest.journalApp.controller;

import net.engineeringdigest.journalApp.entity.User;
import net.engineeringdigest.journalApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

     @Autowired
    private UserService userService;

     @GetMapping
     public List<User> getAllUser(){
         return userService.getAll();
     }

     @PostMapping
     public void createUser(@RequestBody User user){
          userService.saveEntry(user);
     }

     @PutMapping
    private ResponseEntity<?> updateUser(@RequestBody User user){
         User userInDb = userService.findByUserName(user.getUserName());
          if (userInDb != null){
              userInDb.setUserName(user.getUserName());
              userInDb.setPassword(user.getPassword());
              userService.saveEntry(userInDb);
          }
          return new ResponseEntity<>(HttpStatus.NO_CONTENT );
     }


}
