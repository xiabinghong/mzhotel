package com.mzhotel.login.controller;

import com.mzhotel.login.dto.QueryUserInfo;
import com.mzhotel.login.service.loginService;
import com.mzhotel.userInfo.dto.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RequestMapping("/login")
@RestController
public class LoginController {

    @Autowired
    loginService loginService;

    @RequestMapping(value = "/login", method = POST)
    public void login(@RequestBody @Valid QueryUserInfo queryUserInfo, HttpSession session) {
        UserInfo userInfo = loginService.selectUserBylogin(queryUserInfo);
        if (userInfo == null) {
            System.out.println("登陆失败");
            return;
        }
        if(session.getAttribute(userInfo.getUserId()) != null){
            session.removeAttribute(userInfo.getUserId());
        }
        session.setAttribute("userId", userInfo.getUserId());
    }

}
