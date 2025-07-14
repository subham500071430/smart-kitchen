package com.myapp.service.controller;

import com.myapp.service.dto.*;
import com.myapp.service.service.PendingApprovalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("admin")
public class AdminController {

       @Autowired
       private PendingApprovalService pendingApprovalService;

       @PostMapping(path = "/login", produces = "application/json", consumes = "application/json")
       ResponseEntity<JwtLoginResponse> login(@RequestBody LoginRequest loginRequest) {
              return ResponseEntity.ok(null);
       }

       @PostMapping(path = "/signup", produces = "application/json", consumes = "application/json")
       ResponseEntity<SignUpResponse> signup(@RequestBody SignUpRequest signUpRequest) {
              return ResponseEntity.ok(null);
       }

       @GetMapping(path = "/pendingApprovals")
       ResponseEntity<PendingApprovalsResponse> getPendingApprovals(){
              return ResponseEntity.ok(pendingApprovalService.getPendingApprovals());
       }
}
