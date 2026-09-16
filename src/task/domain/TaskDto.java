package task.domain;

import java.util.List;
import java.util.UUID;

import task.domain.user.IUser;

public class TaskDto {

    private final UUID taskId;

    private String title; 

    private UUID assignee; 

    private UUID assignor; 

    TaskStatus currentStatus;

    public UUID getTaskId() {
        return this.taskId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public UUID getAssignee() {
        return assignee;
    }

    public void setAssignee(UUID assignee) {
        this.assignee = assignee;
    }

    public UUID getAssignor() {
        return assignor;
    }

    public void setAssignor(UUID assignor) {
        this.assignor = assignor;
    }

    public void setCurrentStatus(TaskStatus status) {
        this.currentStatus = status;
    }


    public TaskDto(String title, UUID assignee, UUID assignor) {
        
        taskId = UUID.randomUUID();
        this.title = title;
        this.assignee = assignee;
        this.assignor = assignor;
        currentStatus = TaskStatus.TODO;
    }

    public void updateStatus(TaskStatus to) {
        currentStatus = to;
    }

    public TaskStatus getCurrentStatus() {
        return this.currentStatus;
    }

    @Override
    public String toString() {
        return "TaskDto [title=" + title + ", assignee=" + assignee + ", assignor=" + assignor + ", status=" + currentStatus
                + "]";
    }
}
