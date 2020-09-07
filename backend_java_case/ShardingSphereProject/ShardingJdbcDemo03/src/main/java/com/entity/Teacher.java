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
@Entity
@Table
public class Teacher {

    @Id
    @Column(name = "t_id")
    private Long tId;

    @Column(name = "t_name")
    private String tName;

    @Column(name = "t_key")
    private Long tKey;

    public Long gettId() {
        return tId;
    }

    public void settId(Long tId) {
        this.tId = tId;
    }

    public String gettName() {
        return tName;
    }

    public void settName(String tName) {
        this.tName = tName;
    }

    public Long gettKey() {
        return tKey;
    }

    public void settKey(Long tKey) {
        this.tKey = tKey;
    }

    @Override
    public String toString() {
        return "TTeacher{" +
                "tId=" + tId +
                ", tName='" + tName + '\'' +
                ", tKey=" + tKey +
                '}';
    }
}
