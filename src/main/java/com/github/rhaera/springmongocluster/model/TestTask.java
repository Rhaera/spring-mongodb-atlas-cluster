package com.github.rhaera.springmongocluster.model;

import lombok.*;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "test_tasks")
public class TestTask {

    @Id
    private String taskId;
    private String description;
    private String assignee;
    private int severity;
    private int storyPoints;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TestTask testTask = (TestTask) o;

        return this.taskId.equals(testTask.taskId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(taskId, description);
    }
}
