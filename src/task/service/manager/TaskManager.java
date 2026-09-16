package task.service.manager;

import java.util.List;
import java.util.UUID;

import task.domain.TaskDto;
import task.domain.TaskStatus;
import task.domain.user.IUser;
import task.repository.task.TaskRepository;
import task.repository.user.UserRepository;
import task.service.handler.WorkFlowHandler;

public class TaskManager {

    private final UserManager userManager;

    private final TaskRepository taskRepository;

    private final WorkFlowHandler workFlowHandler;

    public TaskManager(TaskRepository taskRepository, UserManager userManager, WorkFlowHandler workFlowHandler) {
        this.workFlowHandler = workFlowHandler;
        this.taskRepository = taskRepository;
        this.userManager = userManager;
    }


    public List<TaskDto> getTasksAssignedToUser(UUID userId) {
        return taskRepository.getTaskByAssignee(userId);
    }

    public List<TaskDto> getTasksAssignor(UUID userId) {
        return taskRepository.getTaskByAssignor(userId);
    }

    public void addTask(TaskDto task) {
        taskRepository.addTask(task);
    }

    public void changeStatus(UUID taskID, UUID user, TaskStatus toStatus) {

        IUser requestingUser = userManager.getUser(user);
        if (requestingUser == null) return;
        TaskDto subjectTask = taskRepository.getTask(taskID);
        if (subjectTask == null) return;

        workFlowHandler.handleTaskEvent(subjectTask, requestingUser, toStatus);
    }
}