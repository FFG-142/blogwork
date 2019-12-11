package com.scs.web.blog.dao;

import com.scs.web.blog.entity.ArticleAdd;

import java.sql.SQLException;
import java.util.List;

/**
 * @author jh_wu
 * @ClassName AtricleAddDao
 * @Description TODO
 * @Date 2019/12/5
 * @Version 1.0
 **/
public interface ArticleAddDao {

    int insert(ArticleAdd articleadd) throws SQLException;
    List<ArticleAdd> selectAll() throws SQLException;
}
