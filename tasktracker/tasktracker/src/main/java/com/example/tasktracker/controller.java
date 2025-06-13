package com.example.tasktracker;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.Model;
@Controller
@RequestMapping("/task")
public class controller {

    @Autowired
    private TaskTrackService service;

    @GetMapping("/all")
    public String listTasks(Model model) {
        model.addAttribute("tasks", service.getAllTasks());
        return "tasks";
    }

    @GetMapping("/form")
    public String addForm(Model model) {
        model.addAttribute("task", new task());
        return "taskForm";
    }
    @GetMapping("/incomplete")
    public String showIncompleteTasks(Model model) {
        List<task> incompleteTasks = service.getIncompleteTasks();
        model.addAttribute("tasks", incompleteTasks);
        return "tasks"; 
    }

    @GetMapping("/complete")
    public String showcCompleteTasks(Model model) {
        List<task> incompleteTasks = service.getCompleteTasks();
        model.addAttribute("tasks", incompleteTasks);
        return "tasks"; 
    }
    @GetMapping("/update/{id}")
    public String updateForm(@PathVariable int id, Model model) {
        task t = service.getTaskById(id);
        model.addAttribute("task", t);
        return "update";
    }
    
    
    @PostMapping("/save")
    public String saveTask(@ModelAttribute("task") task t) {
        service.addTask(t);
        return "redirect:/task/all";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        service.deleteTask(id);
        return "redirect:/task/all";
    }
}
