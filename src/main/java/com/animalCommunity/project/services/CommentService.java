package com.animalCommunity.project.services;

import com.animalCommunity.project.mappers.CommentMapper;
import com.animalCommunity.project.models.Comment;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CommentService {
    private final CommentMapper commentMapper;
    public CommentService(CommentMapper commentMapper){
        this.commentMapper = commentMapper;
    }
    public List<Comment> commentList(int postUid){
        return commentMapper.commentList(postUid);
    }
    public boolean commentCreate(Comment comment){
        return commentMapper.commentCreate(comment);
    }
    public boolean commentDelete(Comment comment){
        return commentMapper.commentDelete(comment);
    }
    public boolean commentUpdate(Comment comment){
        return commentMapper.commentUpdate(comment);
    }
}
