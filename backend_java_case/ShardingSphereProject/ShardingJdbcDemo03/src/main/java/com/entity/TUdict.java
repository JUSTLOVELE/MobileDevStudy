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
@Table(name = "t_udict")
public class TUdict {

    @Id
    @Column(name = "dict_id")
    private Long dictId;

    @Column(name = "dict_status")
    private String dictStatus;

    @Column(name = "dict_value")
    private String dictValue;

    public Long getDictId() {
        return dictId;
    }

    public void setDictId(Long dictId) {
        this.dictId = dictId;
    }

    public String getDictStatus() {
        return dictStatus;
    }

    public void setDictStatus(String dictStatus) {
        this.dictStatus = dictStatus;
    }

    public String getDictValue() {
        return dictValue;
    }

    public void setDictValue(String dictValue) {
        this.dictValue = dictValue;
    }

    @Override
    public String toString() {
        return "TUdict{" +
                "dictId=" + dictId +
                ", dictStatus='" + dictStatus + '\'' +
                ", dictValue='" + dictValue + '\'' +
                '}';
    }
}
