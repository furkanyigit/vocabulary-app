package com.vocabularyapp.auth;

import com.vocabularyapp.entitiy.User;
import com.vocabularyapp.service.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService service;
    private final UserServiceImpl userServiceImpl;
    @GetMapping("")
    public List<User> getVocabulary(){
        return  userServiceImpl.getAll();
    }
    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody RegisterRequest request
    ) {
        return ResponseEntity.ok(service.register(request));
    }
    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request
    ) {
        return ResponseEntity.ok(service.authenticate(request));
    }


}
