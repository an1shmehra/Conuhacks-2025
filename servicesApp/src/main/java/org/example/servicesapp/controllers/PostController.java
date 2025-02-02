package org.example.servicesapp.controllers;

import jakarta.servlet.http.HttpServletResponse;
import org.bson.types.ObjectId;
import org.example.servicesapp.Post;
import org.example.servicesapp.exceptions.PostNotFoundException;
import org.example.servicesapp.repositories.PostRepository;
import org.example.servicesapp.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/post")
public class PostController {
    @Autowired
    private PostService postService;

    @GetMapping
    public ResponseEntity<List<Post>> getAllPosts() {
        return new ResponseEntity<List<Post>>(postService.allPosts(), HttpStatus.OK);
    }

    @GetMapping("/{title}")
    public ResponseEntity<Optional<Post>> getSinglePost(@PathVariable String title) {
        return new ResponseEntity<Optional<Post>>(postService.singlePost(title), HttpStatus.OK);
    }
}
