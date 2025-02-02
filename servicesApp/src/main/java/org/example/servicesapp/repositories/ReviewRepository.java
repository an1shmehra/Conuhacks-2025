package org.example.servicesapp.repositories;

import org.bson.types.ObjectId;
import org.example.servicesapp.Review;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReviewRepository extends MongoRepository<Review, ObjectId> {
}
