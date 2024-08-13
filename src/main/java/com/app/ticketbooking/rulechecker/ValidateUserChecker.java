package com.app.ticketbooking.rulechecker;

import com.app.ticketbooking.models.User;
import com.app.ticketbooking.payload.request.LoginRequest;
import com.app.ticketbooking.payload.request.SignUpRequest;
import com.app.ticketbooking.payload.response.errors.ErrorResponse;
import com.app.ticketbooking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Base64;
import java.util.Objects;
import java.util.Optional;

@Component
public class ValidateUserChecker implements RuleChecker {

    @Autowired
    public UserRepository userRepository;

    @Override
    public Optional<ErrorResponse> loginChecker(LoginRequest request, String requestPassword) {
        User userData = userExists(request.getUserName()).get();
        String decodeUserPassword = Arrays.toString(Base64.getDecoder().decode(userData.getPassword()));
        if (decodeUserPassword.equals(requestPassword)) {
            return Optional.of(ErrorResponse.PASSWORD_DOES_NOT_MATCH);
        }
        return Optional.empty();
    }

    @Override
    public Optional<ErrorResponse> registerChecker(SignUpRequest request, String password, String reTypePassword) {
        if (userExists(request.getUserName()).isPresent()) {
            return Optional.of(ErrorResponse.USER_ALREADY_EXISTS);
        } else if (!Objects.equals(password, reTypePassword)) {
            return Optional.of(ErrorResponse.PASSWORD_DOES_NOT_MATCH);
        }
        return Optional.empty();
    }

    private Optional<User> userExists(String userName) {
        return userRepository.findByUserName(userName);
    }
}