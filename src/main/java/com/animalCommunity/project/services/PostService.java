package com.animalCommunity.project.services;

import com.animalCommunity.project.dtos.PostDto;
import com.animalCommunity.project.dtos.WriteDto;
import com.animalCommunity.project.mappers.PostMapper;
import com.animalCommunity.project.models.Post;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class PostService {

    @Autowired
    PostMapper postMapper;


    public void insertPost(WriteDto writeDto, int userUid){
        Post post = Post.builder()
                .mainUid(writeDto.getMainUid())
                .pageUid(writeDto.getPageUid())
                .title(writeDto.getTitle())
                .content(writeDto.getContent())
                .userUid(userUid)
                .build();

        postMapper.insertPost(post);
    }

    public List<Post> selectPosts(int pageUid) {
        return postMapper.selectPosts(pageUid);
    }

    public Post detailPost(int uid){
        System.out.println(postMapper.detailPost(uid));
        return postMapper.detailPost(uid);
    }

    public List<Post> myPosts(int userUid){
        return postMapper.myPosts(userUid);
    }
    public void updatePost(WriteDto writeDto, int userUid){
        Post post = Post.builder()
                        .uid(writeDto.getUid())
                        .userUid(userUid)
                        .mainUid(writeDto.getMainUid())
                        .pageUid(writeDto.getPageUid())
                        .title(writeDto.getTitle())
                        .content(writeDto.getContent())
                        .build();

        postMapper.updatePost(post);
    }

    public void deletePost(PostDto postDto, int userUid){
        Post post = Post.builder()
                        .uid(postDto.getUid())
                                .userUid(userUid)
                                        .build();
        postMapper.deletePost(post);

    }

    public void incrementLikeCount(int uid) {
        postMapper.incrementLikeCount(uid);
    }

}
