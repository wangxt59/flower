package com.flower.search.service;

import com.flower.search.dao.ArticleSearchDao;
import com.flower.search.pojo.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class ArticleSearchService {
    @Autowired
    private ArticleSearchDao articleSearchDao;

    public Page<Article> findByTitleLike(String keywords, int page, int size) {
        PageRequest pageRequest = PageRequest.of(page-1, size);
        return articleSearchDao.findByTitleOrContentLike(keywords,keywords,  pageRequest);
    }



    /**
     * 增加文章
     * @param article
     */
    public void save(Article article){
        articleSearchDao.save(article);
    }
}
