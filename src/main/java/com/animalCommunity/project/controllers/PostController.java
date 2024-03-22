package com.animalCommunity.project.controllers;

import com.animalCommunity.project.dtos.WriteDto;
import com.animalCommunity.project.models.Post;
import com.animalCommunity.project.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {

    @Autowired
    PostService postService;

    @PostMapping("/write")
    public String write(@RequestBody WriteDto writeDto){
        int userUid = (Integer)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        postService.insertPost(writeDto);
        return "test";
    }

    @GetMapping("/dogposts")
    public List<Post> dogposts(@RequestParam(name="pageUid") int pageUid){
        return postService.selectPosts(pageUid);
    }

    @GetMapping("/catposts")
    public List<Post> catposts(@RequestParam(name="pageUid") int pageUid){
        return postService.selectPosts(pageUid);
    }
    @GetMapping("/etcposts")
    public List<Post> etcposts(@RequestParam(name="pageUid") int pageUid){
        return postService.selectPosts(pageUid);
    }


    @PostMapping("/updatepost")
    public String updatepost(@RequestBody Post post){
        int userUid = (Integer)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        postService.updatePost(post);
        return "test";
    }

}
