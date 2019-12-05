package com.scs.web.blog.service;

import com.scs.web.blog.domain.dto.UserDto;
import com.scs.web.blog.factory.ServiceFactory;
import com.scs.web.blog.util.Result;
import org.junit.Test;

public class UserServiceTest {
    private UserService userService = ServiceFactory.getUserServiceInstance();

    @Test
    public void signUp() {
        UserDto userDao = new UserDto();
        userDao.setMobile("13166667777");
        userDao.setPassword("222");
        Result result = userService.signUp(userDao);
        System.out.println("code:" + result.getCode() + "," + "msg:" + result.getMsg());
    }

    @Test
    public void getHotUsers() {
        Result result = userService.getHotUsers();
        System.out.println(result);
    }

}