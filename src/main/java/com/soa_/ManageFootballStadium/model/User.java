package com.soa_.ManageFootballStadium.model;

import com.soa_.ManageFootballStadium.model._enum.Role;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String username;
    private String password;
    private String email;
    private String phone;
    private Role role; // "USER" or "ADMIN"
}