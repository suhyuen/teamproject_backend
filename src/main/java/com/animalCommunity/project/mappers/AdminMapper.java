package com.animalCommunity.project.mappers;

import com.animalCommunity.project.dtos.AdminDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdminMapper {

    void adminWrite(AdminDto admin);
    void updateAdminPost(AdminDto admin);
    void deleteAdminPost(AdminDto admin);


}
