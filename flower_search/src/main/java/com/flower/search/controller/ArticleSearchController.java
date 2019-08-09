package com.flower.search.controller;

import com.flower.common.entity.PageResult;
import com.flower.common.entity.Result;
import com.flower.common.entity.StatusCode;
import com.flower.search.pojo.Article;
import com.flower.search.service.ArticleSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/article")
public class ArticleSearchController {
    @Autowired
    private ArticleSearchService articleSearchService;


    @RequestMapping(value="/search/{keywords}/{page}/{size}",method=  RequestMethod.GET)
    public Result findByTitleLike(@PathVariable String keywords, @PathVariable int page, @PathVariable int size){
        System.out.println("keywords:"+keywords+"\n"+"page:"+page+"\n"+"size:"+size);
        Page<Article> articlePage = articleSearchService.findByTitleLike(keywords,page,size);
        return new Result(true, StatusCode.OK, "查询成功", new PageResult<Article>(articlePage.getTotalElements(),  articlePage.getContent()));
    }



    @RequestMapping(method= RequestMethod.POST)
    public Result save(@RequestBody Article article){
        articleSearchService.save(article);
        return new Result(true, StatusCode.OK, "操作成功");
    }
}
