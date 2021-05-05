package com.ex.utils.flow.entity;

import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


/**
 * @Description:流程表
 * @Copyright: Copyright (c) 2017 HYKJ All Rights Reserved
 * @Company: 福建互医科技有限公司
 * @author yangzl 2019-12-06
 * @version 1.00.00
 * @history:
 */
@TableName("public_flow_main_tbl")
public class PublicFlowMainEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String opId;

	private Date createTime;

	private String flowDesc;

	private Integer isStop;

	private String keyCode;

	private String mainName;

	private Integer mainType;

	private Integer nodeNumber;

	private String orgId;

	private String userName;

	private String userOpId;

	public PublicFlowMainEntity() {

	}

	public String getOpId() {
		return opId;
	}

	public void setOpId(String opId) {
		this.opId = opId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getFlowDesc() {
		return flowDesc;
	}

	public void setFlowDesc(String flowDesc) {
		this.flowDesc = flowDesc;
	}

	public Integer getIsStop() {
		return isStop;
	}

	public void setIsStop(Integer isStop) {
		this.isStop = isStop;
	}

	public String getKeyCode() {
		return keyCode;
	}

	public void setKeyCode(String keyCode) {
		this.keyCode = keyCode;
	}

	public String getMainName() {
		return mainName;
	}

	public void setMainName(String mainName) {
		this.mainName = mainName;
	}

	public Integer getMainType() {
		return mainType;
	}

	public void setMainType(Integer mainType) {
		this.mainType = mainType;
	}

	public Integer getNodeNumber() {
		return nodeNumber;
	}

	public void setNodeNumber(Integer nodeNumber) {
		this.nodeNumber = nodeNumber;
	}

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserOpId() {
		return userOpId;
	}

	public void setUserOpId(String userOpId) {
		this.userOpId = userOpId;
	}
}