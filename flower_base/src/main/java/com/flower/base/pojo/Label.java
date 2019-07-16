package com.flower.base.pojo;

import javax.persistence.*;

/**
 * 标签实体类
 */
@Entity
@Table(name="tb_label")
public class Label {
    @Id
//    @GeneratedValue
    private String id;//
    @Column
    private String labelName;//标签名称
    @Column
    private String state;//状态
    @Column
    private Long count;//使用数量
    @Column
    private Long fans;//关注数
    @Column
    private String recommend;//是否推荐
    public Label(){}

    public Label(String labelName, String state, Long count, Long fans, String recommend) {
        this.labelName = labelName;
        this.state = state;
        this.count = count;
        this.fans = fans;
        this.recommend = recommend;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLabelName() {
        return labelName;
    }

    public void setLabelName(String labelName) {
        this.labelName = labelName;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public Long getFans() {
        return fans;
    }

    public void setFans(Long fans) {
        this.fans = fans;
    }

    public String getRecommend() {
        return recommend;
    }

    public void setRecommend(String recommend) {
        this.recommend = recommend;
    }
}
