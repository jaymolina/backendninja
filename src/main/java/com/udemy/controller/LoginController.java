package com.udemy.controller;

import com.udemy.constant.ViewConstant;
import com.udemy.model.UserCredential;
import com.udemy.service.ContactService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller

public class LoginController {

    private static Log LOGGER = LogFactory.getLog(LoginController.class);

    @Autowired
    @Qualifier("ContactServiceImpl")
    private ContactService contactService;

    @GetMapping("/login")
    public String showLoginForm(Model model,
        @RequestParam(value = "error", required = false) String error,
        @RequestParam(value = "logout", required = false) String logout){
        LOGGER.info("METHOD: showLoginForm() -- PARAMS: " + "error=" + error + "logout=" + logout);
        model.addAttribute("logout", logout);
        model.addAttribute("error", error);
        model.addAttribute("UserCredential", new UserCredential());
        return ViewConstant.LOGIN;
    }

    @GetMapping({"/loginsuccess", "/"})
    public String loginCheck(){
        LOGGER.info("METHOD: loginCheck())");
        LOGGER.info("RETURNING TO CONTACTS VIEW");
        return "redirect:/contacts/showcontacts";
    }
}
