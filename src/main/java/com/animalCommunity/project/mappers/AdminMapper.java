package com.animalCommunity.project.mappers;

import com.animalCommunity.project.dtos.AdminDto;
import com.animalCommunity.project.models.Admin;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdminMapper {

    void adminWrite(AdminDto admin);
    List<Admin> selectAdminPost();
    List<Admin> selectAdminPostTip();
    void updateAdminPost(AdminDto admin);
    void deleteAdminPost(AdminDto admin);
    Admin selectDetailAdminPost(int uid);

}