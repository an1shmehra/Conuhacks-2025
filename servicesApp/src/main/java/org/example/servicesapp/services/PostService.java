package org.example.servicesapp.services;

import org.bson.types.ObjectId;
import org.example.servicesapp.Post;
import org.example.servicesapp.repositories.PostRepository;
import org.example.servicesapp.util.VisibilityType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public List<Post> allPosts() {
        return postRepository.findAll();
    }

    public Optional<Post> singlePost(String title) {
        return postRepository.findPostByTitle(title);
    }

    @Autowired
    private MongoTemplate mongoTemplate;

    public Post createPost(ObjectId userId, ObjectId postId) {
        Post post = postRepository.insert(new Post());
        mongoTemplate.update(User.class)
                .matching(Criteria.where("userId").is(userId))
                .apply(new Update().push("postId").value(post))
                .first();
        return post;
    }

}
