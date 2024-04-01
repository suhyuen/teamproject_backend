package com.animalCommunity.project.controllers;

import com.animalCommunity.project.dtos.CommentDto;
import com.animalCommunity.project.dtos.PostDto;
import com.animalCommunity.project.models.Comment;
import com.animalCommunity.project.services.CommentService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentController {
    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }
    @GetMapping("/detailpost/comments")
    public List<Comment> commentList (@RequestParam(value="postUid") int postUid){
        System.out.println(postUid);
        return commentService.commentList(postUid);
    }
    @PostMapping("/detailpost/{postUid}/comments")
    public String commentCreate(@RequestBody CommentDto commentDto, @PathVariable("postUid") int postUid){
        int userUid = (Integer) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        commentService.commentCreate(commentDto, userUid, postUid);
        return "test";
    }
    @PostMapping("/detailpost/{postUid}/deletecomment")
    public void commentDelete(@RequestBody CommentDto commentDto, @PathVariable("postUid") int postUid){
        int userUid = (Integer)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        commentService.commentDelete(commentDto, userUid);
    }
    @PostMapping("/detailpost/{postUid}/updatecomment")
    public void commentUpdate(@RequestBody CommentDto commentDto, @PathVariable("postUid") int postUid){
        int userUid = (Integer)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        commentService.commentUpdate(commentDto, userUid);
    }
}
