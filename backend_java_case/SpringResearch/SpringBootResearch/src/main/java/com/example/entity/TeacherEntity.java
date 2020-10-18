package com.example.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "teacher")
public class TeacherEntity {

    @Id
    @Column(name = "op_id", length = 64)
    private String opId;

    @Column(name = "teacher_name", length = 64)
    private String teacherName;

    public void setOpId(String opId) {
        this.opId = opId;
    }

    public String getOpId() {
        return opId;
    }

    public void setTeacherName(String name){
        this.teacherName = name;
    }

    public String getTeacherName() {
        return teacherName;
    }

    @Override
    public String toString() {
        return "TeacherEntity{" +
                "opId='" + opId + '\'' +
                ", teacherName='" + teacherName + '\'' +
                '}';
    }
}
