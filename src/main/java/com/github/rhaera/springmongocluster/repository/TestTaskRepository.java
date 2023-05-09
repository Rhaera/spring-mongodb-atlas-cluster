package com.github.rhaera.springmongocluster.repository;

import com.github.rhaera.springmongocluster.model.TestTask;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestTaskRepository extends MongoRepository<TestTask, String> {

    List<TestTask> findBySeverity(int severity);

    @Query("{assignee: ?0}")
    List<TestTask> getTaskByAssignee(String assignee);

}
