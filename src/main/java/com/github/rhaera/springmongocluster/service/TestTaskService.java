package com.github.rhaera.springmongocluster.service;

import com.github.rhaera.springmongocluster.model.TestTask;

import com.github.rhaera.springmongocluster.repository.TestTaskRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TestTaskService {

    @Autowired
    private TestTaskRepository repository;

    public Optional<TestTask> addNewTask(TestTask task) {
        task.setTaskId(UUID.randomUUID().toString().split("-")[0]);

        return Optional.of(repository.save(task));
    }

    public List<TestTask> findAllTestTasks() {
        return repository.findAll();
    }

    public Optional<TestTask> getTaskById(String taskId) {
        return Optional.of(repository.findById(taskId)).get();
    }

    public List<TestTask> getTaskBySeverity(int severity) {
        return repository.findBySeverity(severity);
    }

    public List<TestTask> getTaskByAssignee(String assignee) {
        return repository.getTaskByAssignee(assignee);
    }

    public TestTask updateTask(TestTask taskRequest) {
        TestTask existingTask;

        if (repository.findById(taskRequest.getTaskId()).isPresent())
            existingTask = repository.findById(taskRequest.getTaskId()).get();
        else
            existingTask = new TestTask(UUID.randomUUID().toString().split("-")[0], "", "", 0, 0);

        existingTask.setDescription(taskRequest.getDescription());
        existingTask.setSeverity(taskRequest.getSeverity());
        existingTask.setAssignee(taskRequest.getAssignee());
        existingTask.setStoryPoints(taskRequest.getStoryPoints());

        return repository.save(existingTask);
    }

    public String deleteTask(String taskId) {
        repository.deleteById(taskId);

        return taskId + " task deleted from dashboard ";
    }
}
