package com.flower.article.service;

import com.flower.article.dao.CommentDao;
import com.flower.article.pojo.Comment;
import com.flower.common.util.IdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    @Autowired
    private CommentDao commentDao;
    @Autowired
    private IdWorker idWorker;



    public List<Comment> findByArticleid(String articleid){
        return commentDao.findByArticleid(articleid);
    }


    public void add(Comment comment){
        comment.setId( idWorker.nextId()+"" );
        commentDao.save(comment);
    }
}
