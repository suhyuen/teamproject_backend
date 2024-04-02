package com.animalCommunity.project.controllers;

import com.animalCommunity.project.dtos.AdminDto;
import com.animalCommunity.project.models.Admin;
import com.animalCommunity.project.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AdminController {

    @Autowired
    AdminService adminService;

    @PostMapping("/adminwrite")
    public void adminwrite(@RequestBody AdminDto adminDto){
        int userUid = (Integer)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        adminDto.setUserUid(userUid);
        adminService.adminWrite(adminDto);
    }

    @GetMapping("/homenotice")
    public List<Admin> home(){
        System.out.println(adminService.selectAdminPost());
        return adminService.selectAdminPost();
    }

    @GetMapping("/tip")
    public List<Admin> hometip(){
        System.out.println(adminService.selectAdminPostTip());
        return adminService.selectAdminPostTip();
    }

    @GetMapping("/notice")
    public List<Admin> notice(){
        return adminService.selectAdminPost();
    }

    @PostMapping("/updateadminpost")
    public void updateadminpost(@RequestBody AdminDto adminDto){
        System.out.println(adminDto.getMainUid());
        adminService.updateAdminPost(adminDto);
    }

    @DeleteMapping("/deleteadminpost")
    public void adminupdatedelete(@RequestBody AdminDto adminDto){
        adminService.deleteAdminPost(adminDto);
    }

    @GetMapping("/updateadminpost")
    public Admin detailadminpost(@RequestParam("uid") int uid){
        System.out.println(uid);
        return adminService.selectDetailAdminPost(uid);
    }

}

