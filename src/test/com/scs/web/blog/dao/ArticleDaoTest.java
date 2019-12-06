package com.scs.web.blog.dao;

import com.scs.web.blog.domain.vo.ArticleVo;
import com.scs.web.blog.entity.Article;
import com.scs.web.blog.factory.DaoFactory;
import com.scs.web.blog.util.JSoupSpider;
import org.junit.Test;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

public class ArticleDaoTest {

    private ArticleDao articleDao = DaoFactory.getArticleDaoInstance();

    @Test
    public void batchInsert() throws SQLException {
        articleDao.batchInsert(JSoupSpider.getArticles());
    }

    @Test
    public void selectHotArticles() throws SQLException {
        List<ArticleVo> articleVoList = articleDao.selectHotArticles();
        System.out.println(articleVoList.size());
    }

    @Test
    public void getArticle() throws SQLException {
        ArticleVo article = articleDao.getArticle(1);
        System.out.println(article);
    }

    @Test
    public void selectByKeywords() throws SQLException {
        List<ArticleVo> articleVoList = articleDao.selectByKeywords("微");
        System.out.println(articleVoList.size());
    }

    @Test
    public void selectByPage() throws SQLException {
        List<ArticleVo> articleVoList = articleDao.selectByPage(1, 10);
        articleVoList.forEach(System.out::println);
    }

    @Test
    public void singleInsert() throws SQLException {
        Article article = new Article();
        article.setTitle("情感剧场");
        article.setSummary("不逼一逼自己，怎么能知道自己有多强");
        article.setThumbnail("https://upload-images.jianshu.io/upload_images/3097674-ef123e711a6ffa5b.jpg");
        article.setContent("不逼一逼自己，怎么能知道自己有多强。不逼一逼自己，怎么能知道自己有多强。");
        article.setLikes(4544);
        article.setComments(1533);
        article.setCreateTime(LocalDateTime.now());

        System.out.println( articleDao.singleInsert(article));

    }

    @Test
    public void batchDelete() throws SQLException {
        int n = articleDao.batchDelete(109);
        System.out.println(n);
    }

    @Test
    public void singleAlter() throws SQLException {
        Article article = new Article();
        article.setTitle("情感剧场");
        article.setSummary("不逼一逼自己，怎么能知道自己有多强");
        article.setThumbnail("https://upload-images.jianshu.io/upload_images/3097674-ef123e711a6ffa5b.jpg");
        article.setContent("不逼一逼自己，怎么能知道自己有多强。不逼一逼自己，怎么能知道自己有多强。");
        article.setLikes(4544);
        article.setComments(1533);
        article.setCreateTime(LocalDateTime.now());
        article.setId((long) 101);
        int n = articleDao.singleAlter(article);
        System.out.println(n);
    }
}