package com.scs.web.blog.dao;

import com.scs.web.blog.domain.dto.UserDto;
import com.scs.web.blog.entity.User;
import com.scs.web.blog.factory.DaoFactory;
import com.scs.web.blog.util.JSoupSpider;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

public class UserDaoTest {
    private UserDao userDao = DaoFactory.getUserDaoInstance();


    @Test
    public void insertUser() throws SQLException {
        UserDto user = new UserDto();
        user.setMobile("13900001111");
        user.setPassword("111");
        userDao.insert(user);
    }

    @Test
    public void batchInsert() throws SQLException {
        userDao.batchInsert(JSoupSpider.getUsers());
    }

    @Test
    public void findUserByMobile() throws SQLException {
        User user = userDao.findUserByMobile("13011112222");
        if (user != null) {

            System.out.println(user);
        } else {
            System.out.println("手机号不存在");
        }
    }

    @Test
    public void selectHotUsers() throws SQLException {
        List<User> userList = userDao.selectHotUsers();
        userList.forEach(System.out::println);
    }

    @Test
    public void selectByKeywords() throws SQLException {
        List<User> userList = userDao.selectByKeywords("王");
        System.out.println(userList.size());
    }

    @Test
    public void update() throws SQLException {
    }

}