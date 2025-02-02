package org.example.servicesapp.repositories;

import org.bson.types.ObjectId;
import org.example.servicesapp.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, ObjectId> {
    Optional<User> findUserByUsername(String username);
    List<User> findByPosts(List<String> posts);
//    Optional<User> findByUserId(ObjectId id);
}
