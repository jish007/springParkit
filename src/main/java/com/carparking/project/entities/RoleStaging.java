package com.carparking.project.entities;

import com.carparking.project.domain.RoleDto;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public class RoleStaging {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "rolename")
    private String roleName;

    private String responsibilities;
    private String adminMailId;

    public RoleStaging() {
    }

    public RoleStaging(RoleDto roleDto, String email) {
        this.roleName = roleDto.getRoleName();
        this.responsibilities = roleDto.getResponsibilities();
        this.adminMailId = email;
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

    public String getAdminMailId() {
        return adminMailId;
    }

    public void setAdminMailId(String adminMailId) {
        this.adminMailId = adminMailId;
    }

    public void setResponsibilities(String responsibilities) {
        this.responsibilities = responsibilities;
    }
}
