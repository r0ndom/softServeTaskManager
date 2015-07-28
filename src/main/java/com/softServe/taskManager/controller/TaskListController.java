package com.softServe.taskManager.controller;


import com.softServe.taskManager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
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

//    @RequestMapping(value = "/createList", method = RequestMethod.POST)
//    @ResponseStatus(value = HttpStatus.OK)
//    public void addNewTaskList(List list) {
//        listService.addTaskList(list);
//    }
//
//    @RequestMapping(value = "/editList", method = RequestMethod.POST)
//    @ResponseStatus(value = HttpStatus.OK)
//    public void editTaskListName(String oldName, String newName) throws Exception {
//        listService.editTaskList(oldName, newName);
//    }
//
//    @RequestMapping(value = "/deleteList", method = RequestMethod.POST)
//    @ResponseStatus(value = HttpStatus.OK)
//    public void deleteTaskList(String name) {
//        listService.deleteTaskList(name);
//    }
//
//    @RequestMapping(value = "/createTask", method = RequestMethod.POST)
//    @ResponseStatus(value = HttpStatus.OK)
//    public void createTask(String listName, Task task) {
//        taskService.addTask(listName, task);
//    }
//
//    @RequestMapping(value = "/editTask", method = RequestMethod.POST)
//    //@ResponseStatus(value = HttpStatus.OK)
//    public @ResponseBody
//    void editTask(@RequestBody RequestWrapper requestWrapper) {
//        taskService.editTask(requestWrapper.getListName(), requestWrapper.getOldName(), requestWrapper.getTask());
//    }
//
//    @RequestMapping(value = "/deleteTask", method = RequestMethod.POST)
//    @ResponseStatus(value = HttpStatus.OK)
//    public void deleteTask(String listName, String name) {
//        taskService.deleteTask(listName, name);
//    }
}
