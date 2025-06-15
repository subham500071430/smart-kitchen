package com.myapp.service.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class RoleApprovals {

    @Column
    private String emailId;
    @Column
    private String name;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

}
