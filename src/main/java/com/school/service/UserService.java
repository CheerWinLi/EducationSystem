package com.school.service;

import javax.servlet.http.HttpServletResponse;

import com.school.entity.vo.LoginVo;

/**
 * @author :Lictory
 * @date : 2024/05/13
 */
public interface UserService {
    LoginVo login(String username, String password, HttpServletResponse response);

    /**
     * 添加用户
     *
     * @param type     type
     * @param relateId relateId
     * @param username username
     * @return true or false
     */
    Boolean addUser(Integer type, Integer relateId, String username);
}
