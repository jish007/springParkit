package com.carparking.project.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "roles_master")
public class Role {

    @Id
    @Column(name="rolename")
    private String roleName;

    private String responsibilities;

    public Role() {
    }

    public Role(String roleName, String responsibilities) {
        this.roleName = roleName;
        this.responsibilities = responsibilities;
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
}
