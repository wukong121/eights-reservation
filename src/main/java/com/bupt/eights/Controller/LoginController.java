package com.bupt.eights.Controller;


import com.bupt.eights.model.AuthorityRole;
import com.bupt.eights.model.User;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
    
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
}
