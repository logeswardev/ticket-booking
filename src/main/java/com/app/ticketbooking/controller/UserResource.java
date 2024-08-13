package com.app.ticketbooking.controller;

import com.app.ticketbooking.payload.request.LoginRequest;
import com.app.ticketbooking.payload.request.SignUpRequest;
import com.app.ticketbooking.payload.response.errors.ErrorResponse;
import com.app.ticketbooking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.core.Response;
import java.util.Optional;

@RestController
@RequestMapping("user/")
public class UserResource {

    @Autowired
    UserService userService;

    @PostMapping("/login")
    public ResponseEntity<?> signIn(@RequestBody LoginRequest request){
        Optional<ErrorResponse> collectErrors = userService.login(request);
        if(collectErrors.isPresent()){
            return ResponseEntity.status(collectErrors.get().getStatusCode()).body(collectErrors.get().getErrorMessage());
        }
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody SignUpRequest request){
        Optional<ErrorResponse> collectErrors = userService.registerUser(request);
        if(collectErrors.isPresent()){
            return ResponseEntity.status(collectErrors.get().getStatusCode()).body(collectErrors.get().getErrorMessage());
        }
        return ResponseEntity.noContent().build();
    }
}
