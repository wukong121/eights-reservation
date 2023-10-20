package com.bupt.eights.Controller;


import com.bupt.eights.model.AuthorityRole;
import com.bupt.eights.model.User;
import com.bupt.eights.response.HttpResponse;
import com.bupt.eights.service.LoginService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import cn.hutool.core.util.RandomUtil;


@Slf4j
@Controller
@RequestMapping("/user")
public class LoginController {
    
    @Autowired
    LoginService loginService;
    
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
    
    @ResponseBody
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public HttpResponse<String> createUser(@RequestBody User user) {
        
        loginService.createUser(user);
        
        HttpResponse<String> response = new HttpResponse<>();
        response.setStatus("success");
        response.setCode(HttpStatus.OK.value());
        response.setMessage("注册成功");
        log.info("用户" + user.getUserName() + "注册成功");
        return response;
    }

    public void sendCode(String phone, HttpSession session) {
        // 1.校验手机号
        if (com.bupt.eights.utils.RegexUtils.isPhoneInvalid(phone)) {
            // 2.如果不符合，返回错误信息
            log.info("手机号格式错误！");
        }
        // 3.符合，生成验证码
        String code = RandomUtil.randomNumbers(6);

        TODO://保存验证码到 redis
        //stringRedisTemplate.opsForValue().set(LOGIN_CODE_KEY + phone, code, LOGIN_CODE_TTL, TimeUnit.MINUTES);

        // 5.发送验证码
        log.debug("发送短信验证码成功，验证码：{}", code);
        // 返回ok

    }
}
