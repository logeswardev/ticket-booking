package com.app.ticketbooking.rulechecker;

import com.app.ticketbooking.payload.request.LoginRequest;
import com.app.ticketbooking.payload.request.SignUpRequest;
import com.app.ticketbooking.payload.response.errors.ErrorResponse;

import java.util.Optional;

public interface RuleChecker {

    Optional<ErrorResponse> loginChecker(LoginRequest loginRequest, String requestPassword);
    Optional<ErrorResponse> registerChecker(SignUpRequest loginRequest, String password, String reTypePassword);

}
