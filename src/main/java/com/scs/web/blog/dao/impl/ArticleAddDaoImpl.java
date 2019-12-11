package com.scs.web.blog.dao.impl;

import com.scs.web.blog.dao.ArticleAddDao;
import com.scs.web.blog.entity.ArticleAdd;
import com.scs.web.blog.util.DbUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


/**
 * @author jh_wu
 * @ClassName ArticleAddDaoImpl
 * @Description TODO
 * @Date 2019/12/5:10:20
 * @Version 1.0
 **/
public class ArticleAddDaoImpl implements ArticleAddDao {

    @Override
    public int insert(ArticleAdd articleadd) throws SQLException {
        Connection connection = DbUtil.getConnection();
        String sql = "INSERT INTO t_article (user_id,topic_id,title,summary,thumbnail,content,likes,comments,create_time) VALUES (?,?,?,?,?,?,?,?,?) ";
        PreparedStatement pst = connection.prepareStatement(sql);
        pst.setLong(1, articleadd.getUserId());
        pst.setLong(2, articleadd.getTopicId());
        pst.setString(3, articleadd.getTitle());
        pst.setString(4, articleadd.getSummary());
        pst.setString(5, articleadd.getThumbnail());
        pst.setString(6, articleadd.getContent());
        pst.setInt(7,0);
        pst.setInt(8,0);
        pst.setObject(9, articleadd.getCreateTime());
        pst.executeUpdate();
        int n = pst.executeUpdate();
        DbUtil.close(connection, pst);
        return n;
    }

    @Override
    public List<ArticleAdd> selectAll() throws SQLException {
        List<ArticleAdd> articleAddList = new ArrayList<>();
        Connection connection = DbUtil.getConnection();
        String sql = "SELECT * FROM t_article ORDER BY id DESC ";
        PreparedStatement pstmt = connection.prepareStatement(sql) ;
        ResultSet rs = pstmt. executeQuery();
        while (rs.next()) {
            ArticleAdd comment = new ArticleAdd();
            comment. setId(rs.getLong("id"));
            comment. setUserId (rs.getLong("user_id"));
            comment. setContent(rs.getString("content"));
            Timestamp timestamp = rs.getTimestamp("create_time");
            comment.setCreateTime (timestamp.toLocalDateTime());
            articleAddList.add(comment);
        }
        return articleAddList ;
    }
}
