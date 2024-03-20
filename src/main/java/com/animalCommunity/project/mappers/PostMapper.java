package com.animalCommunity.project.mappers;

import com.animalCommunity.project.dtos.WriteDto;
import com.animalCommunity.project.models.Post;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PostMapper {
    void insertPost(WriteDto writeDto);
    List<Post> selectPosts(int pageUid);

    List<Post> myPosts(int userUid);
}
