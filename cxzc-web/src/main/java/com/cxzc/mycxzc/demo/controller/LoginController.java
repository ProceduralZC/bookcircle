package com.cxzc.mycxzc.demo.controller;
import com.cxzc.mycxzc.demo.bean.User;
import com.cxzc.mycxzc.demo.response.Result;
import com.cxzc.mycxzc.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

import javax.servlet.http.HttpSession;
import java.util.Objects;

@Controller
public class LoginController {
    @Autowired
    UserService userService;

    @CrossOrigin
    @PostMapping(value = "req/login")
    @ResponseBody
    public Result login(@RequestBody User requestUser, HttpSession session) {
        String username = requestUser.getUsername();
        username = HtmlUtils.htmlEscape(username);

        User user = userService.get(username, requestUser.getPassword());
        if (null == user) {
            return new Result(400);
        } else {
            //用户对象User添加到session中
            session.setAttribute("userinfo", user);
            return new Result(200);
        }
    }
}

