package com.xia.lawyer.models.system;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

/**
 * Created by lindeng on 2/17/2017.
 */
@Entity
@Table(name = "t_sys_permission")
public class Permission {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @Column(name="id")
    private String id;

    @Column(name = "permission_name",nullable = false,length = 64)
    private String permissionName;

    @Column(columnDefinition = "enum('menu','button')")
    private String resourceType;

    @Column(name="permission_url",nullable = true,length = 256)
    private String url;

    @Column(name="permission_str",nullable = false,length = 64)
    private String permissionStr;

    @Column(name="parent_id")
    private String parentId;

    @Column(name="available")
    private boolean available=false;

    @ManyToMany
    @JoinTable(name="t_sys_role_permission",joinColumns = { @JoinColumn(name = "permission_id")}, inverseJoinColumns = {
            @JoinColumn(name = "role_id") })
    private List<Role> roles;

    @ManyToMany
    @JoinTable(name="t_sys_department_permission",joinColumns = { @JoinColumn(name = "permission_id")}, inverseJoinColumns = {
            @JoinColumn(name = "department_id") })
    private List<Department> departments;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public String getResourceType() {
        return resourceType;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPermissionStr() {
        return permissionStr;
    }

    public void setPermissionStr(String permissionStr) {
        this.permissionStr = permissionStr;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }

    @Override
    public String toString() {
        return "Permission{" +
                "id='" + id + '\'' +
                ", resourceType='" + resourceType + '\'' +
                ", url='" + url + '\'' +
                ", permissionStr='" + permissionStr + '\'' +
                ", parentId='" + parentId + '\'' +
                ", available=" + available +
                '}';
    }
}
