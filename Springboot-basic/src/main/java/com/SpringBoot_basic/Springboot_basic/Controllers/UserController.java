package com.SpringBoot_basic.Springboot_basic.Controllers;


import com.SpringBoot_basic.Springboot_basic.Entities.User;
import com.SpringBoot_basic.Springboot_basic.Services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/api/users/")
    public ResponseEntity<?> getAllUsers(){
        try{
            List<User> userList=userService.getAllusers();
            return ResponseEntity.ok(userList);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @GetMapping("/api/users/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Integer id){
        try{
            User user = userService.getUserById(id);
            if(user!=null){
                return ResponseEntity.status(201).body(user);
            }else{
                return ResponseEntity.status(404).body("usuario con id "+id+" no existe");
            }
        }catch (Exception e ){
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @PostMapping("/api/users")
    public ResponseEntity<?>postNewUser(@RequestBody User user){
        try {
            User newUser=userService.postUser(user);
            return ResponseEntity.ok(newUser);
        }catch (Exception e){
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }
}
