package com.bupt.eights.controller;


import com.bupt.eights.dto.request.LoginRequest;
import com.bupt.eights.dto.request.RegisterRequest;
import com.bupt.eights.dto.response.LoginResponse;
import com.bupt.eights.model.AuthorityRole;
import com.bupt.eights.model.User;
import com.bupt.eights.dto.response.HttpResponse;
import com.bupt.eights.service.AuthenticateService;
import com.bupt.eights.utils.JwtTokenUtils;
import com.bupt.eights.utils.URLConstant;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Slf4j
@Controller
@RequestMapping(URLConstant.LOGIN_URL)
public class LoginController {
    
    @Autowired
    AuthenticateService loginService;
    
    private String redirectByRole(HttpServletRequest request) {
        if (request.isUserInRole(AuthorityRole.ROLE_ADMIN.toString())) {
            return "redirect:/admin";
        }
        if (request.isUserInRole(AuthorityRole.ROLE_STUDENT.toString())) {
            return "redirect:/students/home";
        }
        return "";
    }
    
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String showLogin(@ModelAttribute(value = "user") User user, HttpServletRequest request) {
        String path = redirectByRole(request);
        if (path.isEmpty()) {
            return "login";
        }
        return path;
    }
    
    @RequestMapping(value = "/login-success", method = RequestMethod.GET)
    public String loginSuccess(HttpServletRequest request) {
        String path = redirectByRole(request);
        if (path.isEmpty()) {
            return "redirect:/home";
        }
        return path;
    }
    
    @RequestMapping(value = "/login-failed", method = RequestMethod.GET)
    public String loginFailed(@ModelAttribute(value = "user") User user, Model model) {
        model.addAttribute("fail", true);
        return "login";
    }
    
    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public HttpResponse<String> createUser(@RequestBody @Valid RegisterRequest request) {
        User user = loginService.createUser(request);
        HttpResponse<String> response = new HttpResponse<>();
        response.setStatus("success");
        response.setCode(HttpStatus.OK.value());
        response.setMessage("注册成功");
        response.setData(user.getUserId());
        log.info("用户" + user.getUserName() + "注册成功");
        return response;
    }
    
    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "/oauth/token", method = RequestMethod.POST)
    public HttpResponse<LoginResponse> login(@RequestBody @Valid LoginRequest loginRequest) {
        HttpResponse<LoginResponse> response = loginService.authenticate(loginRequest);
        if (response.getCode() != 200) {
            return response;
        }
        String jwtToken = JwtTokenUtils.createToken(loginRequest.getUserName(), AuthorityRole.ROLE_STUDENT,
                loginRequest.isRemember());
        response.data.setToken(jwtToken);
        return response;
    }
}
