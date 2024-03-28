package com.animalCommunity.project.mappers;

import com.animalCommunity.project.dtos.PostDto;
import com.animalCommunity.project.dtos.WriteDto;
import com.animalCommunity.project.models.Post;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PostMapper {
    void insertPost(Post post);
    List<Post> selectPosts(int pageUid);

    Post detailPost(int uid);

    List<Post> myPosts(int userUid);

    void updatePost(Post post);

    void deletePost(PostDto postDto);

    void incrementLikeCount(int uid);
}
