package com.myapp.service.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class UserRole {

       @Id
       @GeneratedValue(strategy = GenerationType.IDENTITY)
       private Long id;
       @ManyToOne
       @JoinColumn(name = "emailId" , referencedColumnName = "emailId")
       private User user;
       @Enumerated(EnumType.STRING)
       @Column(nullable = false)
       private Role role;

}
