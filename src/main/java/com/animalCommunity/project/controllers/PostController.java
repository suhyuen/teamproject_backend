package com.animalCommunity.project.controllers;

import com.animalCommunity.project.dtos.WriteDto;
import com.animalCommunity.project.models.Post;
import com.animalCommunity.project.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {

    @Autowired
    PostService postService;

    @PostMapping("/write")
    public String write(@RequestBody WriteDto writeDto){
        postService.insertPost(writeDto);
        return "test";
    }

    @GetMapping("/dogposts")
    public List<Post> selectPosts(@RequestParam(name="pageUid") int pageUid){
        return postService.selectPosts(pageUid);
    }

    @PostMapping("myposts")
    public List<Post> myPosts(@RequestBody Post post){
        return postService.myPosts();
    }
}
