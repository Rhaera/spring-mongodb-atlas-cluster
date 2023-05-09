package com.github.rhaera.springmongocluster.controller;

import com.github.rhaera.springmongocluster.model.TestTask;
import com.github.rhaera.springmongocluster.service.TestTaskService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tasks")
public class TestTaskController {

    @Autowired
    private TestTaskService service;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<TestTask> createTask(@RequestBody TestTask task) {
        return ResponseEntity.of(service.addNewTask(task));
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<TestTask> getAllTasks() {
        return service.findAllTestTasks();
    }

    @GetMapping("/{taskId}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<TestTask> findTaskById(@PathVariable("taskId") String taskId) {
        return ResponseEntity.of(service.getTaskById(taskId));
    }

    @GetMapping("/severity/{severity}")
    @ResponseStatus(HttpStatus.OK)
    public List<TestTask> findTaskBySeverity(@PathVariable("severity") int severity) {
        return service.getTaskBySeverity(severity);
    }

    @GetMapping("/assignee/{assignee}")
    @ResponseStatus(HttpStatus.OK)
    public List<TestTask> findTaskByAssignee(@PathVariable("assignee") String assignee) {
        return service.getTaskByAssignee(assignee);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<TestTask> modifyTask(@RequestBody TestTask task) {
        return ResponseEntity.of(Optional.of(service.updateTask(task)));
    }

    @DeleteMapping("/{taskId}")
    @ResponseStatus(HttpStatus.OK)
    public String deleteTask(@PathVariable("taskId") String taskId) {
        return service.deleteTask(taskId);
    }
}
