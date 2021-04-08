package com.ss.entity;

import com.baomidou.mybatisplus.annotation.TableName;

/**
 * @author yangzl 2021.04.08
 * @version 1.00.00
 * @Description:
 * @history:
 */
@TableName("public_user_tbl")
public class UserEntity {

    private String opId;

    private String userName;

    private String userPassword;

    public String getOpId() {
        return opId;
    }

    public void setOpId(String opId) {
        this.opId = opId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    @Override
    public String toString() {
        return "User{" +
                "opId='" + opId + '\'' +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                '}';
    }
}
