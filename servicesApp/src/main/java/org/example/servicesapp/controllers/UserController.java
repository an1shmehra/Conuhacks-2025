package org.example.servicesapp.controllers;

import org.bson.types.ObjectId;
import org.example.servicesapp.User;
import org.example.servicesapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;

    //TODO: THIS CLASS
//    @PostMapping
//    public ResponseEntity<Optional<User>> createUser(@RequestBody Map<String, ObjectId> payload) {
//        return new ResponseEntity<Optional<User>>(userService.createUser(payload.get("userId")))
//    }
}
