package com.sunpeihua.login.controller;

import com.sunpeihua.login.common.BaseMessageVO;
import com.sunpeihua.login.service.LoginService;
import com.sunpeihua.login.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: sunpeihua
 * @create: 2019/3/28 22:59
 **/
@RestController
public class LoginController {
    private final LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/register")
    public BaseMessageVO register(@RequestBody UserVO userVO) {
        if (userVO.getUsername() == null || userVO.getUsername().equals("")) {
            return new BaseMessageVO(10, "用户名不存在或不合法");
        }
        if (!loginService.checkUsername(userVO.getUsername())) {
            return new BaseMessageVO(20, "用户名已存在");
        }
        try {
            if (loginService.register(userVO)) {
                return new BaseMessageVO();
            } else {
                return new BaseMessageVO(30, "未知错误");
            }
        } catch (Exception e) {
            return new BaseMessageVO(500, e.getMessage());
        }
    }

    @GetMapping("/active")
    public void active() {

    }

    @PostMapping("login")
    public void login() {

    }

    @GetMapping("logout")
    public void logout() {

    }
}
