package com.app.ticketbooking.repository;

import com.app.ticketbooking.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface UserRepository extends MongoRepository<User, String> {

    Optional<User> findByUserName(String userName);
    Optional<User> findByEmail(String email);

}
