package com.finalassignment.bookworm.controller;

import com.finalassignment.bookworm.dto.AdminDto;
import com.finalassignment.bookworm.service.impl.AdminServiceImpl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class AdminController {

    private final AdminServiceImpl adminService;

    public AdminController(AdminServiceImpl adminService) {
        this.adminService = adminService;
    }

    @PostMapping("/bookworm/addAdmin")
    public ResponseEntity<AdminDto> addAdmin(@Valid @RequestBody AdminDto adminDto) {

        AdminDto addAdmin = adminService.addAdmin(adminDto);
        return new ResponseEntity(addAdmin, new HttpHeaders(), HttpStatus.OK);

    }


    @GetMapping(value = "/bookworm/showAdminById/{admin_id}")
    public AdminDto  showAdminById(@PathVariable Long admin_id) {
//      log.debug("Getting Customers By Id.");
        return adminService.findById(admin_id);
    }

    @GetMapping("/bookworm/showAllAdmins")
    public ResponseEntity<List> showAllAdmins() {

        return ResponseEntity.ok(adminService.getAdmin());

    }
}
