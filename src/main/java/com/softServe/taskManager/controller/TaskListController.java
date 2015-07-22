package com.softServe.taskManager.controller;


import com.softServe.taskManager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/list")
public class TaskListController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView showList() {
        ModelAndView mav = new ModelAndView("list/list");
        mav.addObject("listArray", userService.getCurrentUser().getLists());
        return mav;
    }
}
