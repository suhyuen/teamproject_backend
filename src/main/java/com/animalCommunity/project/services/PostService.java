package com.animalCommunity.project.services;

import com.animalCommunity.project.dtos.WriteDto;
import com.animalCommunity.project.mappers.PostMapper;
import com.animalCommunity.project.models.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    PostMapper postMapper;

    public void insertPost(WriteDto writeDto){
        postMapper.insertPost(writeDto);
    }

    public List<Post> selectPosts(int pageUid) {
        return postMapper.selectPosts(pageUid);
    }

    public List<Post> myPosts(int userUid){
        return postMapper.myPosts(userUid);
    }


}
