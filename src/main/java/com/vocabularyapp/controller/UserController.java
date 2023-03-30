package com.vocabularyapp.controller;

import com.vocabularyapp.entitiy.User;
import com.vocabularyapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("")
    public List<User> getUser(){
        return userService.getAll();
    }

    @PostMapping("/register")
    public ResponseEntity<User> create (@RequestBody User newUser){
        User user = userService.save(newUser);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }
    @PostMapping("/login")
    public boolean login (@RequestBody User user){
        return userService.login(user);
    }
    @PutMapping("/{id}")
    public Boolean update(@RequestBody User newUser,@PathVariable Long id){
        return userService.update(newUser, id);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {userService.deleteById(id);
    }

}
