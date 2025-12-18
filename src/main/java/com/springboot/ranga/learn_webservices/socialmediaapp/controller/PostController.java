package com.springboot.ranga.learn_webservices.socialmediaapp.controller;

import com.springboot.ranga.learn_webservices.socialmediaapp.model.Post;
import com.springboot.ranga.learn_webservices.socialmediaapp.service.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PostController {

    PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/users/{userId}/posts")
    public ResponseEntity<List<Post>> getAllUsersPosts(@PathVariable("userId") int userId){
        return ResponseEntity.ok(postService.getAllPost(userId));
    }

    @GetMapping("/users/{userId}/posts/{postId}")
    public ResponseEntity<List<Post>> getUserById(@PathVariable("userId") int userId, @PathVariable("postId") int postId){
        return ResponseEntity.ok(postService.getPostById(userId,postId));
    }

    @PostMapping("/users/{userId}/posts")
    public ResponseEntity<Post> createUsersPosts(@PathVariable("userId") int userId){
        return ResponseEntity.ok(postService.createUsersPosts(userId));
    }




}
