package com.animalCommunity.project.controllers;

import com.animalCommunity.project.models.Comment;
import com.animalCommunity.project.services.CommentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentController {
    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }
    @GetMapping("/commentList")
    public List<Comment> commnetList (@RequestParam(value="postUid") int postUid){
        return commentService.commentList(postUid);
    }
    @PostMapping("/commentCreate")
    public boolean commentCreate(@RequestBody Comment comment){
        return commentService.commentCreate(comment);
    }
    @PostMapping("/commentDelete")
    public boolean commentDelete(@RequestBody Comment comment){
        return commentService.commentDelete(comment);
    }
    @PostMapping("/commentUpdate")
    public boolean commentUpdate(@RequestBody Comment comment){
        return commentService.commentUpdate(comment);
    }
}
