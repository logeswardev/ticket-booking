package com.app.ticketbooking.payload.request;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
public class SignUpRequest {

    @NonNull
    private String userName;

    @NonNull
    private String emailId;

    @NonNull
    private String phoneNumber;

    @NonNull
    private String password;

    @NonNull
    private String reTypePassword;
}
