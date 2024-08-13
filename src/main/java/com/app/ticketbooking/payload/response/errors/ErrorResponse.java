package com.app.ticketbooking.payload.response.errors;


import lombok.Getter;

import javax.ws.rs.core.Response;

@Getter
public enum ErrorResponse {

    USER_ALREADY_EXISTS(1000, "User already exists", Response.Status.INTERNAL_SERVER_ERROR.getStatusCode()),
    PASSWORD_DOES_NOT_MATCH(1001, "Password does not match", Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());

    private final long errorCode;
    private final String errorMessage;
    private final int statusCode;

    ErrorResponse(long errorCode, String errorMessage, int statusCode){
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.statusCode = statusCode;
    }
}
