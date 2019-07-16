package com.wang.entity;

import java.util.Date;

public class MMenu {
    private String mId;

    private String menuId;

    private String menuName;

    private String parentid;

    private String levels;

    private String model;

    private String status;

    private String xmlid;

    private String url;

    private String relateSubId;

    private String menuDesciption;

    private Date createDate;

    private Date updateDate;

    private String operator;

    private Integer sort;

    private String iconUrl;

    public String getmId() {
        return mId;
    }

    public void setmId(String mId) {
        this.mId = mId == null ? null : mId.trim();
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId == null ? null : menuId.trim();
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName == null ? null : menuName.trim();
    }

    public String getParentid() {
        return parentid;
    }

    public void setParentid(String parentid) {
        this.parentid = parentid == null ? null : parentid.trim();
    }

    public String getLevels() {
        return levels;
    }

    public void setLevels(String levels) {
        this.levels = levels == null ? null : levels.trim();
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model == null ? null : model.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getXmlid() {
        return xmlid;
    }

    public void setXmlid(String xmlid) {
        this.xmlid = xmlid == null ? null : xmlid.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getRelateSubId() {
        return relateSubId;
    }

    public void setRelateSubId(String relateSubId) {
        this.relateSubId = relateSubId == null ? null : relateSubId.trim();
    }

    public String getMenuDesciption() {
        return menuDesciption;
    }

    public void setMenuDesciption(String menuDesciption) {
        this.menuDesciption = menuDesciption == null ? null : menuDesciption.trim();
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

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl == null ? null : iconUrl.trim();
    }
}