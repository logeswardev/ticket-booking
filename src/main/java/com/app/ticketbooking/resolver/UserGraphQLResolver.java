package com.app.ticketbooking.resolver;

import com.app.ticketbooking.models.User;
import com.app.ticketbooking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserGraphQLResolver {

    @Autowired
    public final UserService userService;

    UserGraphQLResolver(UserService userService){
        this.userService = userService;
    }

//    public User signup(String username, String password, String email) {
//        return userService.signUp(username, password, email);
//    }
//
//    public User login(Log) {
//        return userService.login(username, password);
//    }
}
