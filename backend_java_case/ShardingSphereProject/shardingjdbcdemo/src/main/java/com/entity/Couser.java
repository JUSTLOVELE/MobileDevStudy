package com.entity;

/**
 * @author yangzl 2020.08.27
 * @version 1.00.00
 * @Description:
 * @history:
 */
public class Couser {

    private Long cid;

    private String cname;

    private Long userId;

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
