package com.animalCommunity.project.services;

import com.animalCommunity.project.dtos.AdminDto;
import com.animalCommunity.project.mappers.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    AdminMapper adminMapper;

    public void adminWrite(AdminDto adminDto) {
        adminMapper.adminWrite(adminDto);
    }

    public void updateAdminPost(AdminDto adminDto) {
        adminMapper.updateAdminPost(adminDto);
    }

    public void deleteAdminPost(AdminDto adminDto) {
        adminMapper.deleteAdminPost(adminDto);
    }


}
