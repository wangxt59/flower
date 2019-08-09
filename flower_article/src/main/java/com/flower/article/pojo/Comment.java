package com.flower.article.pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * 文章评论（mongoDB）
 * @author Administrator
 *
 */
public class Comment implements Serializable{
    @Id
    private String _id;
    @Column
    private String articleid;
    @Column
    private String content;
    @Column
    private String userid;
    @Column
    private String parentid;
    @Column
    private Date publishdate;
//getter and setter....

    public Comment(String _id, String articleid, String content, String userid, String parentid, Date publishdate) {
        this._id = _id;
        this.articleid = articleid;
        this.content = content;
        this.userid = userid;
        this.parentid = parentid;
        this.publishdate = publishdate;
    }

    public Comment() {
    }

    @Override
    public String toString() {
        return "Comment{" +
                "_id='" + _id + '\'' +
                ", articleid='" + articleid + '\'' +
                ", content='" + content + '\'' +
                ", userid='" + userid + '\'' +
                ", parentid='" + parentid + '\'' +
                ", publishdate=" + publishdate +
                '}';
    }

    public String getId() {
        return _id;
    }

    public void setId(String _id) {
        this._id = _id;
    }

    public String getArticleid() {
        return articleid;
    }

    public void setArticleid(String articleid) {
        this.articleid = articleid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getParentid() {
        return parentid;
    }

    public void setParentid(String parentid) {
        this.parentid = parentid;
    }

    public Date getPublishdate() {
        return publishdate;
    }

    public void setPublishdate(Date publishdate) {
        this.publishdate = publishdate;
    }
}
