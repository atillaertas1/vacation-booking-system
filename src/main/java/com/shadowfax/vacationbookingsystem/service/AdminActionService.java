package com.shadowfax.vacationbookingsystem.service;

import com.shadowfax.vacationbookingsystem.model.AdminAction;
import com.shadowfax.vacationbookingsystem.repository.AdminActionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminActionService {

    @Autowired
    private AdminActionRepository adminActionRepository;

    public AdminAction createAdminAction(AdminAction adminAction) {
        return adminActionRepository.save(adminAction);
    }

    public List<AdminAction> getAllAdminActions() {
        return adminActionRepository.findAll();
    }

    public AdminAction getAdminActionById(Long id) {
        Optional<AdminAction> optionalAdminAction = adminActionRepository.findById(id);

        return optionalAdminAction.orElse(null);
    }

    public boolean deleteAdminAction(Long id) {
        Optional<AdminAction> optionalAdminAction = adminActionRepository.findById(id);

        if(optionalAdminAction.isPresent()){
            adminActionRepository.delete(optionalAdminAction.get());
            return true;
        }
        return false;
    }
}
