package org.example.servicesapp.repositories;

import org.bson.types.ObjectId;
import org.example.servicesapp.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PostRepository extends MongoRepository<Post, ObjectId> {
    Optional<Post> findPostByTitle(String title);
}

