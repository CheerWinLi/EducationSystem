package com.school.service.impl;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.school.entity.po.User;
import com.school.entity.vo.LoginVo;
import com.school.mapper.UserMapper;
import com.school.service.UserService;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

/**
 * @author :Lictory
 * @date : 2024/05/13
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {


    private static final String PASSWORD = "password";

    @Override
    public LoginVo login(String username, String password, HttpServletResponse response) {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getUsername, username);
        User user = baseMapper.selectOne(wrapper);
        Assert.isTrue(user != null, "id or password error");
        if (password.equals(user.getPassword())) {
            // 创建一个名为 "user_id" 的 Cookie，并设置值为用户的用户名
            Cookie userIdCookie = new Cookie("user_id", user.getUsername());
            // 设置 Cookie 的有效期/s
            // 设置为一天
            userIdCookie.setMaxAge(24 * 60 * 60);
            // 设置 Cookie 的路径
            userIdCookie.setPath("/");
            // 将 Cookie 添加到响应中
            response.addCookie(userIdCookie);
            return new LoginVo().setStatus(user.getType()).setStudentId(user.getUsername());
        } else {
            return null;
        }
    }

    @Override
    public Boolean addUser(Integer type, Integer relateId, String username) {
        User newUser = new User();
        newUser.setType(type)
                .setPassword(PASSWORD)
                .setRelateId(relateId)
                .setUsername(username);
        baseMapper.insert(newUser);
        return true;
    }
}
