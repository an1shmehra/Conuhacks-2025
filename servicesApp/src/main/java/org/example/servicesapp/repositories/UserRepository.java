package org.example.servicesapp.repositories;

import org.bson.types.ObjectId;
import org.example.servicesapp.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, ObjectId> {
}
