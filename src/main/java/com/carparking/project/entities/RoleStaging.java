package com.carparking.project.entities;

import com.carparking.project.domain.RoleDto;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public class RoleStaging {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String roleName;

    private String responsibilities;

    private String adminName;

    public RoleStaging() {}

    public RoleStaging(RoleDto roleDto, String email) {
        this.roleName = roleDto.getRoleName();
        this.responsibilities = roleDto.getResponsibilities();
        this.adminName = email;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getResponsibilities() {
        return responsibilities;
    }

    public void setResponsibilities(String responsibilities) {
        this.responsibilities = responsibilities;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }
}

