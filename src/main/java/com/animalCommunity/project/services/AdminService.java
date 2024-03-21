package com.animalCommunity.project.services;

import com.animalCommunity.project.dtos.AdminDto;
import com.animalCommunity.project.mappers.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    AdminMapper adminMapper;

    public void adminPost(AdminDto adminDto) {
        adminMapper.adminPost(adminDto);
    }

    public void adminUpdate(AdminDto adminDto) {
        adminMapper.adminUpdate(adminDto);
    }

    public void adminUpdateDelete(AdminDto adminDto) {
        adminMapper.adminUpdateDelete(adminDto);
    }


}
