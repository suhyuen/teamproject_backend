package com.animalCommunity.project.mappers;


import com.animalCommunity.project.models.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    void addUser(User user);
}
