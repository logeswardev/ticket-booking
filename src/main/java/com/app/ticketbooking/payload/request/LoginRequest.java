package com.app.ticketbooking.payload.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
@Data
public class LoginRequest {

    @NonNull
    @JsonProperty("userName")
    private String userName;

    @NonNull
    @JsonProperty("password")
    private String password;

}
