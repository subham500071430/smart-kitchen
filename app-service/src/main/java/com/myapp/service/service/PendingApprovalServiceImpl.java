package com.myapp.service.service;

import com.myapp.service.dto.PendingApprovals;
import com.myapp.service.dto.PendingApprovalsResponse;
import com.myapp.service.entity.RoleApprovals;
import com.myapp.service.repository.PendingApprovalsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PendingApprovalServiceImpl implements PendingApprovalService {

    @Autowired
    PendingApprovalsRepository repository;

    @Override
    public PendingApprovalsResponse getPendingApprovals() {
        List<RoleApprovals> list = repository.findAll();
        List<PendingApprovals> pendingApprovals = list.stream()
                .map(roleApprovals -> {
                    PendingApprovals dto = new PendingApprovals();
                    dto.setEmailId(roleApprovals.getEmailId());
                    dto.setName(roleApprovals.getName());
                    dto.setRole(String.valueOf(roleApprovals.getRole()));
                    return dto;
                }).collect(Collectors.toList());
        return new PendingApprovalsResponse(pendingApprovals);
    }
}
