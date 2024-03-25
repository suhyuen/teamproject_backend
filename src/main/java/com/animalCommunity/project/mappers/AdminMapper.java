package com.animalCommunity.project.mappers;

import com.animalCommunity.project.dtos.AdminDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdminMapper {

    void adminPost(AdminDto admin);
    void adminUpdate(AdminDto admin);
    void adminUpdateDelete(AdminDto admin);

}
