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
       private long id;
       @ManyToOne
       @JoinColumn(name = "emailId")
       private User user;

}
