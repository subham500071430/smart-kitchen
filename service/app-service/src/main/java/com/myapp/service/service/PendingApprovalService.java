package com.myapp.service.service;

import com.myapp.service.dto.PendingApprovalsResponse;
import org.springframework.stereotype.Service;

@Service
public interface PendingApprovalService {

       public PendingApprovalsResponse getPendingApprovals();
}
