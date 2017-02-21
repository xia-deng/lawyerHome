package com.xia.lawyer.models.system;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

/**
 * Created by lindeng on 2/17/2017.
 */
@Entity
@Table(name="t_sys_user")
public class User {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @Column(name="id")
    private String id;

    @Column(name="user_name",nullable = false,unique = true,length = 40)
    private String username;
    @Column(name="pass_word",nullable = false,length = 250)
    private String password;

    @Column(name = "salt")
    private String salt;

    @OneToOne(mappedBy="user",fetch=FetchType.EAGER)
    private UserDetail userDetail;

    @ManyToOne()
    @JoinColumn(name = "department_id")
    private Department department;

    @ManyToMany
    @JoinTable(name="t_sys_user_role",joinColumns = { @JoinColumn(name = "user_id")}, inverseJoinColumns = {
            @JoinColumn(name = "role_id") })
    private List<Role> roles;

    //用户状态,0:创建未认证（比如没有激活，没有输入验证码等等）--等待验证的用户 , 1:正常状态,2：用户被锁定.
    @Column(name="status")
    private byte status=0;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public UserDetail getUserDetail() {
        return userDetail;
    }

    public void setUserDetail(UserDetail userDetail) {
        this.userDetail = userDetail;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", userDetail=" + userDetail +
                ", department=" + department +
                ", status=" + status +
                '}';
    }

    public User(){}

    public User(String username, String password, String salt, byte status) {
        this.username = username;
        this.password = password;
        this.salt = salt;
        this.status = status;
    }
}
