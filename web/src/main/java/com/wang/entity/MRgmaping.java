package com.wang.entity;

import java.util.Date;

public class MRgmaping {
    private String rgId;

    private String rId;

    private String pgroupId;

    private Date createDate;

    private Date updateDate;

    private String operatorId;

    public String getRgId() {
        return rgId;
    }

    public void setRgId(String rgId) {
        this.rgId = rgId == null ? null : rgId.trim();
    }

    public String getrId() {
        return rId;
    }

    public void setrId(String rId) {
        this.rId = rId == null ? null : rId.trim();
    }

    public String getPgroupId() {
        return pgroupId;
    }

    public void setPgroupId(String pgroupId) {
        this.pgroupId = pgroupId == null ? null : pgroupId.trim();
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

    public String getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId == null ? null : operatorId.trim();
    }
}