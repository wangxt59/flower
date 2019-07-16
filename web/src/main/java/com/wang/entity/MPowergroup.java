package com.wang.entity;

import java.util.Date;

public class MPowergroup {
    private String pgroupId;

    private String groupsName;

    private String groupsDesc;

    private Integer status;

    private Date createDate;

    private Date updateDate;

    private String operator;

    private String sellerId;

    public String getPgroupId() {
        return pgroupId;
    }

    public void setPgroupId(String pgroupId) {
        this.pgroupId = pgroupId == null ? null : pgroupId.trim();
    }

    public String getGroupsName() {
        return groupsName;
    }

    public void setGroupsName(String groupsName) {
        this.groupsName = groupsName == null ? null : groupsName.trim();
    }

    public String getGroupsDesc() {
        return groupsDesc;
    }

    public void setGroupsDesc(String groupsDesc) {
        this.groupsDesc = groupsDesc == null ? null : groupsDesc.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator == null ? null : operator.trim();
    }

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId == null ? null : sellerId.trim();
    }
}