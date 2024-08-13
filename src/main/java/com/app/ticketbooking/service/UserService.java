package com.app.ticketbooking.service;

import com.app.ticketbooking.models.User;
import com.app.ticketbooking.payload.request.LoginRequest;
import com.app.ticketbooking.payload.request.SignUpRequest;
import com.app.ticketbooking.payload.response.errors.ErrorResponse;
import com.app.ticketbooking.repository.UserRepository;
import com.app.ticketbooking.rulechecker.ValidateUserChecker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Base64;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ValidateUserChecker validateUserChecker;

    public UserService(UserRepository userRepository, ValidateUserChecker validateUserChecker){
        this.userRepository = userRepository;
        this.validateUserChecker = validateUserChecker;
    }

    public Optional<ErrorResponse> registerUser(SignUpRequest request) {

        String encodedPassword = Base64.getEncoder().encodeToString(request.getPassword().getBytes());
        String encodedRePassword = Base64.getEncoder().encodeToString(request.getReTypePassword().getBytes());

        Optional<ErrorResponse> errors = validateUserChecker.registerChecker(request, encodedPassword, encodedRePassword);

        if(errors.isPresent()){
            return errors;
        }

        User user = new User();
        user.setUserName(request.getUserName());
        user.setPassword(encodedPassword);
        user.setRetypePassword(encodedRePassword);
        userRepository.save(user);

        return Optional.empty();
    }

    public Optional<ErrorResponse> login(LoginRequest request){
        String decodeRequestPassword = Arrays.toString(Base64.getDecoder().decode(request.getPassword()));
        return validateUserChecker.loginChecker(request, decodeRequestPassword);
    }

}
