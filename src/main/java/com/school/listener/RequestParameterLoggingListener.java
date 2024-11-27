package com.school.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;


@WebListener
public class RequestParameterLoggingListener implements ServletRequestListener {

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        //打印请求参数
        HttpServletRequest request = (HttpServletRequest) sre.getServletRequest();
        System.out.println("Request Parameters:");
        request.getParameterMap().forEach((paramName, paramValues) -> {
            for (String paramValue : paramValues) {
                System.out.println(paramName + " = " + paramValue);
            }
        });
    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        // 请求结束时的逻辑
        System.out.println("Request completed.");
    }
}
