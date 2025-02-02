package org.example.servicesapp.controllers;

import org.bson.types.ObjectId;
import org.example.servicesapp.Review;
import org.example.servicesapp.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/post/reviews")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    @PostMapping("/test")
    public ResponseEntity<Optional<Review>> createReview(@RequestBody Map<ObjectId, ObjectId> payload) {
        return new ResponseEntity<Optional<Review>>(Optional.ofNullable(reviewService.createPost(
                payload.get("reviewId"), payload.get("userId"))), HttpStatus.CREATED);
    }
}
