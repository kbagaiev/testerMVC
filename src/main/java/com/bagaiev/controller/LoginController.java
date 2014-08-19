package com.bagaiev.controller;

import com.bagaiev.entities.Account;
import com.bagaiev.forms.LoginForm;
import com.bagaiev.services.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Kostya on 13.08.2014.
 */
@Controller
public class LoginController {

    @Autowired
    CommonService commonService;

    @RequestMapping(value="/login",method= RequestMethod.POST)
    public String doLogin (@RequestParam String login,
                           @RequestParam String password,
                           @ModelAttribute("loginForm") LoginForm loginForm){

        if (commonService.login(login, password)) {
            return "/login/success";
        } else {

            return "login/failure";
        }

    }

    @RequestMapping(value="/index",method= RequestMethod.GET)
    public String init (Model model){
        model.addAttribute("loginForm", new LoginForm());
            return "/login/form";


    }
}
