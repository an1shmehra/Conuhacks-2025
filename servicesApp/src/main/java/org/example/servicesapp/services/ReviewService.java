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

public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    public Post createPost(ObjectId postId, ObjectId reviewId) {
        Review review = reviewRepository.insert(new Review());
        mongoTemplate.update(Post.class)
                .matching(Criteria.where("userId").is(userId))
                .apply(new Update().push("postId").value(post))
                .first();
        return post;
    }
}
