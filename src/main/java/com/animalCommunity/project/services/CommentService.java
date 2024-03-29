package com.animalCommunity.project.services;

import com.animalCommunity.project.dtos.CommentDto;
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
    public void commentCreate(CommentDto commentDto, int userUid,int postUid) {
        Comment comment1 = Comment.builder()
                .userUid(userUid)
                .postUid(postUid)
                .content(commentDto.getContent())
                .build();

        commentMapper.commentCreate(comment1);
    }
    public void commentDelete(CommentDto commentDto, int userUid){
        Comment comment = Comment.builder()
                .uid(commentDto.getUid())
                        .userUid(userUid)
                                .build();
        commentMapper.commentDelete(comment);
    }
    public boolean commentUpdate(Comment comment){
        return commentMapper.commentUpdate(comment);
    }
}
