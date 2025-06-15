package com.myapp.service.repository;

import com.myapp.service.entity.RoleApprovals;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PendingApprovalsRepository extends JpaRepository<RoleApprovals, String> {

}
