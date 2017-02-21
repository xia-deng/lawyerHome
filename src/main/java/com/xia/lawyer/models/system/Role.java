package com.xia.lawyer.models.system;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

/**
 * Created by lindeng on 2/17/2017.
 */
@Entity
@Table(name = "t_sys_role")
public class Role {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @Column(name="id")
    private String id;

    @Column(name="role",nullable = false,length = 15,unique = true)
    private String role;

    @Column(name="description",nullable = true,length = 32)
    private String description;

    @Column(name="available")
    private boolean available=false;

    @ManyToMany
    @JoinTable(name="t_sys_user_role",joinColumns = { @JoinColumn(name = "role_id")}, inverseJoinColumns = {
            @JoinColumn(name = "user_id") })
    List<User> users;

    @ManyToMany
    @JoinTable(name="t_sys_role_permission",joinColumns = { @JoinColumn(name = "role_id")}, inverseJoinColumns = {
            @JoinColumn(name = "permission_id") })
    List<Permission> permissions;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id='" + id + '\'' +
                ", role='" + role + '\'' +
                ", description='" + description + '\'' +
                ", available=" + available +
                '}';
    }
}
