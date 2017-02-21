package com.xia.lawyer.models.system;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

/**
 * Created by lindeng on 2/17/2017.
 */
@Entity
@Table(name="t_sys_department")
public class Department {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @Column(name="id")
    private String id;

    @Column(name="department",nullable = false,length = 12,unique = true)
    private String department;

    @Column(name="description",nullable = true,length = 32)
    private String description;

    @Column(name="available")
    private boolean available=false;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "department")
    private List<User> users;

    @ManyToMany
    @JoinTable(name="t_sys_department_permission",joinColumns = { @JoinColumn(name = "department_id")}, inverseJoinColumns = {
            @JoinColumn(name = "permission_id") })
    private List<Permission> permissions;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
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
        return "Department{" +
                "id='" + id + '\'' +
                ", department='" + department + '\'' +
                ", description='" + description + '\'' +
                ", available=" + available +
                '}';
    }
}
