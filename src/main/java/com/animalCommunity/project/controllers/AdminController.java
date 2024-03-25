package com.animalCommunity.project.controllers;

import com.animalCommunity.project.dtos.AdminDto;
import com.animalCommunity.project.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {

    @Autowired
    AdminService adminService;

    @PostMapping("/adminwrite")
    public void adminwrite(@RequestBody AdminDto adminDto){
        adminService.adminWrite(adminDto);
    }

    @PostMapping("/updateadminpost")
    public void updateadminpost(@RequestBody AdminDto adminDto){
        adminService.updateAdminPost(adminDto);
    }

    @DeleteMapping("/deleteadminpost")
    public void adminupdatedelete(@RequestBody AdminDto adminDto){
        adminService.deleteAdminPost(adminDto);
    }

}
