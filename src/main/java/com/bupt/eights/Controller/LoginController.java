package com.bupt.eights.Controller;


import com.bupt.eights.model.AuthorityRole;
import com.bupt.eights.model.User;
import com.bupt.eights.response.HttpResponse;
import com.bupt.eights.service.LoginService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


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
}
