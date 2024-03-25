package com.animalCommunity.project.mappers;

import com.animalCommunity.project.models.Comment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommentMapper{
    List<Comment> commentList (int postUid);  // 댓글 리스트 출력
    boolean commentCreate (Comment comment);
    boolean commentDelete (Comment comment);
    boolean commentUpdate (Comment comment);
}
