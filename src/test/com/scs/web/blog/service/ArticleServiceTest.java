package com.scs.web.blog.service;

import com.scs.web.blog.entity.Article;
import com.scs.web.blog.factory.ServiceFactory;
import com.scs.web.blog.util.Result;
import org.junit.Test;

import java.time.LocalDateTime;

public class ArticleServiceTest {
    private ArticleService articleService = ServiceFactory.getArticleServiceInstance();

    @Test
    public void getHotArticles() {
       Result result =  articleService.getHotArticles();
        System.out.println(result.getData());
    }

    @Test
    public void getPageArticles() {
    }

    @Test
    public void getArticle() {
    }

    @Test
    public void batchDelete() {
        Result result =  articleService.batchDelete(112);
        System.out.println(result);
    }

    @Test
    public void singleInsert() {
        Article article = new Article();
        article.setTitle("情感剧场");
        article.setSummary("不逼一逼自己，怎么能知道自己有多强");
        article.setThumbnail("https://upload-images.jianshu.io/upload_images/3097674-ef123e711a6ffa5b.jpg");
        article.setContent("不逼一逼自己，怎么能知道自己有多强。不逼一逼自己，怎么能知道自己有多强。");
        article.setLikes(4544);
        article.setComments(1533);
        article.setCreateTime(LocalDateTime.now());
        article.setId((long) 122);
         Result rs= articleService.singleInsert(article);
        System.out.println(rs);
    }

    @Test
    public void singleAlter() {
        Article article = new Article();
        article.setTitle("时尚杂志");
        article.setSummary("潘多拉魔盒");
        article.setThumbnail("https://upload-images.jianshu.io/upload_images/3097674-ef123e711a6ffa5b.jpg");
        article.setContent("潘多拉魔盒。");
        article.setLikes(4544);
        article.setComments(1533);
        article.setCreateTime(LocalDateTime.now());
        article.setId((long) 111);
        Result rs= articleService.singleAlter(article);
        System.out.println(rs);
    }
}