package com.tangz.shoppingmall.web.controller;

import com.tangz.shoppingmall.meta.User;
import com.tangz.shoppingmall.service.impl.UserServiceImpl;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Controller
public class UserController {
    @Autowired
    private UserServiceImpl userServiceImpl;

    Logger logger= Logger.getLogger(this.getClass());

    @RequestMapping("/login")
    @ResponseBody
    public Map<String, Object> login(HttpServletRequest request,
                                     @RequestParam("name") String name,
                                     @RequestParam("password") String password
    ) {
        HttpSession session = request.getSession();
        Map<String, Object> map = new HashMap<String, Object>();
        int ans = userServiceImpl.checkoutUser(name, password);

        System.out.println(ans);


        if (ans == 0) {
            map.put("code", 0);
        } else {
            map.put("code", 200);
            User user = userServiceImpl.findById(ans);
            session.setAttribute("user", user);
            user.setPassword("");
            map.put("user", user);
        }

        return map;
    }

    @RequestMapping("/logout")
    @ResponseBody
    public Map<String, Object> logout(HttpServletRequest request) {

        HttpSession session = request.getSession();
        session.removeAttribute("user");
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", 200);

        return map;
    }


    @RequestMapping(value = "/register.do", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> registere(
            @RequestParam("name") String name,
            @RequestParam("password") String password) {


        Map<String, Object> map = new HashMap<String, Object>();
        if (userServiceImpl.register(name,password) == true) {

            map.put("code", 200);
        } else {
            map.put("code", 0);
        }

        return map;
    }
}
