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
public class Course {

    @Id
    @Column(name="cid")
    private Long cid;

    @Column(name="cname")
    private String cname;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "c_status")
    private String cStatus;

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getcStatus() {
        return cStatus;
    }

    public void setcStatus(String cStatus) {
        this.cStatus = cStatus;
    }
}
