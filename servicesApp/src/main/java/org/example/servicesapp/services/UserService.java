package org.example.servicesapp.services;

import org.bson.types.ObjectId;
import org.example.servicesapp.User;
import org.example.servicesapp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    public User createUser(String username, String password) {
        User user = new User(username, password);
        userRepository.insert(user);

        mongoTemplate.update(User.class)
                .matching(Criteria.where("password").is(password))
                .apply(new Update().push("User").value(user))
                .first();

        return user;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getByUserId(int id) {
        return userRepository.findById(new ObjectId());
    }

    public Optional<User> getUserByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }

    public List<User> getAllPosts(List<String> posts) {
        return userRepository.findByPosts(posts);
    }
}
