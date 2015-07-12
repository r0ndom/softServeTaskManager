package com.softServe.taskManager.controller;

import com.softServe.taskManager.model.User;
import com.softServe.taskManager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegisterController {

    @Autowired
    public UserService userService;

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView showRegisterPage() {
        return new ModelAndView("register/register", "command", new User());
    }

    @RequestMapping(value = "/addNewUser", method = RequestMethod.POST)
    public String addUser(@ModelAttribute User user) {
        userService.create(user);
        return "redirect:/login";
    }

    @RequestMapping(value = "/validate", method = RequestMethod.GET)
    @ResponseBody
    public boolean checkUserEmail(@RequestParam String email) {
        return userService.isEmailExist(email);
    }
}
