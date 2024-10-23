package com.shadowfax.vacationbookingsystem.controller;

import com.shadowfax.vacationbookingsystem.model.AdminAction;
import com.shadowfax.vacationbookingsystem.service.AdminActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/actions")
public class AdminActionController {

    @Autowired
    private AdminActionService adminActionService;

    @PostMapping
    public ResponseEntity<AdminAction> createAdminAction(@RequestBody AdminAction adminAction) {
        AdminAction createdAdminAction = adminActionService.createAdminAction(adminAction);
        return ResponseEntity.ok(createdAdminAction);
    }

    @GetMapping
    public ResponseEntity<List<AdminAction>> getAllAdminActions(){
        List<AdminAction> adminActionList = adminActionService.getAllAdminActions();
        return ResponseEntity.ok(adminActionList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AdminAction> getAdminActionById(@PathVariable Long id){
        AdminAction adminAction = adminActionService.getAdminActionById(id);
        return adminAction != null ? ResponseEntity.ok(adminAction) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAdminAction(@PathVariable Long id){
        if (adminActionService.deleteAdminAction(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }



}
