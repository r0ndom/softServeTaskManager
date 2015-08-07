package com.softServe.taskManager.controller;


import com.softServe.taskManager.model.Task;
import com.softServe.taskManager.service.TaskService;
import com.softServe.taskManager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/list")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @RequestMapping(method = RequestMethod.GET)
    public String showList(Model model, Integer offset, Integer maxResults){
        model.addAttribute("tasks", taskService.list(offset, maxResults));
        model.addAttribute("count", taskService.count());
        model.addAttribute("offset", offset);
        return "list/list";
    }

    @RequestMapping(value = "/createTask", method = RequestMethod.POST)
    public @ResponseBody Long createTask(@RequestBody Task task) {
        return taskService.addTask(task);
    }

    @RequestMapping(value = "/editTask", method = RequestMethod.POST)
    public void editTask(@RequestBody Task task) {
        taskService.editTask(task);
    }

    @RequestMapping(value = "/deleteTask/{id}", method = RequestMethod.POST)
    public void deleteTask(@PathVariable("id") Long id) {
        taskService.deleteTask(id);
    }
}
