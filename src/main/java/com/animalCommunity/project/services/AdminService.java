package com.animalCommunity.project.services;

import com.animalCommunity.project.dtos.AdminDto;
import com.animalCommunity.project.mappers.AdminMapper;
import com.animalCommunity.project.models.Admin;
import com.animalCommunity.project.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {
    @Autowired
    AdminMapper adminMapper;

    public void adminWrite(AdminDto adminDto) {
        adminMapper.adminWrite(adminDto);
    }

    public List<Admin> selectAdminPost() {
        return adminMapper.selectAdminPost();
    }

    public List<Admin> selectAdminPostTip() {
        return adminMapper.selectAdminPostTip();
    }

    public void updateAdminPost(AdminDto adminDto) {
        adminMapper.updateAdminPost(adminDto);
    }

    public void deleteAdminPost(AdminDto adminDto) {
        adminMapper.deleteAdminPost(adminDto);
    }

    public Admin selectDetailAdminPost(int uid){
        return adminMapper.selectDetailAdminPost(uid);
    }

}