package com.example.tasktracker;

import java.util.List;


import org.springframework.stereotype.Service;

@Service
public class TaskTrackService {

    private final Tasktrackerrepo repo;

    // Constructor Injection
    public TaskTrackService(Tasktrackerrepo repo) {
        this.repo = repo;
    }

    public List<task> getAllTasks() {
        return repo.findAll();
    }

    public task addTask(task task) {
        return repo.save(task);
    }

    public task getTaskById(int id) {
        return repo.findById(id).orElse(null); // or throw exception if not found
    }

    public task updateTask(task task) {
        return repo.save(task); 
    }

    public void deleteTask(int id) {
        repo.deleteById(id);
    }
    public List<task> getIncompleteTasks() {
        return repo.findByCompletedFalse();
    }
    public List<task> getCompleteTasks() {
        return repo.findByCompletedTrue();
    }
}

