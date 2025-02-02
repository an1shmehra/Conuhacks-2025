package org.example.servicesapp.services;

import org.bson.types.ObjectId;
import org.example.servicesapp.Post;
import org.example.servicesapp.Review;
import org.example.servicesapp.repositories.PostRepository;
import org.example.servicesapp.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    public Review createPost(ObjectId postId, ObjectId reviewId) {
        Review review = reviewRepository.insert(new Review());
        mongoTemplate.update(Post.class)
                .matching(Criteria.where("postId").is(postId))
                .apply(new Update().push("reviewId").value(review))
                .first();
        return review;
    }
}
