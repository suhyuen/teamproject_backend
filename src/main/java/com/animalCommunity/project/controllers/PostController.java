package com.animalCommunity.project.controllers;

import com.animalCommunity.project.dtos.PostDto;
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

    @GetMapping("/detailpost")
    public Post detailpost(@RequestParam(name="uid") int uid){
        System.out.println(postService.detailPost(uid));
        return postService.detailPost(uid);
    }


    @PostMapping("/updatepost")
    public String updatepost(@RequestBody Post post){
        int userUid = (Integer)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        postService.updatePost(post);
        return "test";
    }

    @PostMapping("/myposts")
    public List<Post> myposts(@RequestBody Post post){
        int userUid = (Integer)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return postService.myPosts(userUid);
    }

    @PostMapping("/deletePost")
    public String deletePost(@RequestBody PostDto postDto) {
        int userUid = (Integer)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println(postDto);
        postService.deletePost(postDto);
        return "test";
    }

    @GetMapping("/likecount")
    public void likePost(@RequestParam(name="uid") int uid) {
        postService.incrementLikeCount(uid);
    }

}