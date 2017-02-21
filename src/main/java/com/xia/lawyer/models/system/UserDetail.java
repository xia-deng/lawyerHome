package com.xia.lawyer.models.system;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by lindeng on 2/17/2017.
 */
@Entity
@Table(name = "t_sys_user_detail")
public class UserDetail {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @Column(name="id")
    private String id;

    @Column(name="real_name",nullable = false,length = 32)
    private String realName;

    @Column(name="phone_no",nullable = false,length = 32)
    private String phoneNo;

    @Column(name="is_leader")
    private boolean isLeader=false;

    @OneToOne
    @JoinColumn(name = "userId",insertable=true,unique=true)
    private User user;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public boolean isLeader() {
        return isLeader;
    }

    public void setLeader(boolean leader) {
        isLeader = leader;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "UserDetail{" +
                "id='" + id + '\'' +
                ", realName='" + realName + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                ", isLeader=" + isLeader +
                ", user=" + user.getUsername() +
                '}';
    }
}
