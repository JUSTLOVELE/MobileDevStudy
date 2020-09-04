package com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author yangzl 2020.09.04
 * @version 1.00.00
 * @Description:
 * @history:
 */
@Table
@Entity(name = "t_user")
public class TUser {

    @Id
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "user_status")
    private String userStatus;

    @Column(name = "test_id")
    private Long testId;


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }

    public Long getTestId() {
        return testId;
    }

    public void setTestId(Long testId) {
        this.testId = testId;
    }

    @Override
    public String toString() {
        return "TUser{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userStatus='" + userStatus + '\'' +
                ", testId=" + testId +
                '}';
    }
}
