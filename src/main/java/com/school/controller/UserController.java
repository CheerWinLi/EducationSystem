package com.school.controller;

import javax.servlet.http.HttpServletResponse;

import com.school.common.CommonResult;
import com.school.entity.bo.LoginBo;
import com.school.entity.vo.LoginVo;
import com.school.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author :Lictory
 * @date : 2024/05/13
 */
@RestController
@RequestMapping("/api/auth")
@CrossOrigin
public class UserController {


    @Autowired
    private UserService userService;


    @PostMapping("/login")
    public CommonResult<LoginVo> login(@RequestBody LoginBo loginBo, HttpServletResponse response) {
        return CommonResult.autoResult(true, userService.login(loginBo.getUsername(),loginBo.getPassword(),response));
    }

}
