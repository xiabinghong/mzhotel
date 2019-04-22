package com.mzhotel.sm.login.controller;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;
import com.mzhotel.sm.login.dto.QueryUserInfo;
import com.mzhotel.sm.security.service.SecurityService;
import com.mzhotel.sm.userInfo.dto.UserInfo;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.net.InetAddress;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RequestMapping("/login")
@RestController
public class LoginController {

    private static Logger logger = LogManager.getLogger(LoginController.class);

    @Autowired
    com.mzhotel.sm.login.service.loginService loginService;

    @Autowired
    SecurityService securityService;

    @RequestMapping(value = "/login", method = POST)
    public Map<String, Object> login(@RequestBody @Valid QueryUserInfo queryUserInfo, HttpServletRequest request) {
        logger.info(queryUserInfo.getUserId() + "开始登陆");
        Map<String, Object> result = Maps.newHashMap();
        result.put("DATA", "FAIL");
        try {
            HttpSession session = request.getSession();
            boolean isSuccess = loginService.isSuccess(queryUserInfo);
            if (isSuccess) {
                UserInfo userInfo = loginService.selectUserBylogin(queryUserInfo);
                session.setAttribute("userId", queryUserInfo.getUserId());//将userId加入到会话中
                Subject subject = SecurityUtils.getSubject();
                UsernamePasswordToken token = new UsernamePasswordToken(queryUserInfo.getUserId(), queryUserInfo.getUserId());
                token.setRememberMe(false);
                subject.login(token);//shiro安全认证
                //UserInfo userInfo = (UserInfo) subject.getPrincipal();
                Map<String, Object> user = new HashMap<>();
                user.put("loginId", userInfo.getUserId());
                user.put("loginName", userInfo.getUsername());
                user.put("ipAddr", InetAddress.getLocalHost().getHostAddress());
                session.setAttribute("logonInfo", user);//登陆信息放入会话中
                session.setAttribute("username",userInfo.getUsername());
                Set<String> permissions = securityService.getPermissions(userInfo.getUserId());
                session.setAttribute("UserPermissionsJSON", JSONObject.toJSONString(permissions));//将资源加入到会话中，方便页面进行调取
                logger.info(userInfo.getUserId() + "登陆成功,跳入首页");
                result.put("DATA", "SUCCESS");
                return result;
            } else {
                logger.info(queryUserInfo.getUserId() + "登陆失败,跳入重新登陆的页面");
                return result;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

}
