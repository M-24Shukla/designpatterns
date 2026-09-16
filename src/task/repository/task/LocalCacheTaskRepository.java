package task.repository.task;

import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import task.domain.TaskDto;

public class LocalCacheTaskRepository implements TaskRepository {

    private final ConcurrentHashMap<UUID, TaskDto> taskMap;

    public LocalCacheTaskRepository() {
        this.taskMap = new ConcurrentHashMap<>();
    }

    @Override 
    public void addTask(TaskDto taskDto) {
        if (taskMap.contains(taskDto)) {
            System.err.println("Cannot add already present task: %s".formatted(taskDto.getTitle()));
            return;
        }
        System.out.println("Adding new task [%s] in the cache.".formatted(taskDto.getTitle()));

        taskMap.put(taskDto.getTaskId(), taskDto);
    }

    @Override 
    public TaskDto getTask(UUID taskId) {
        TaskDto response = taskMap.get(taskId);

        if (response == null) {
            System.err.println("No such ID exists");
            return response;
        } 
        // System.out.println("Found task: %s".formatted(response));
        return response;
    }

    @Override
    public List<TaskDto> getTaskByAssignee(UUID assigneeId) {
        return taskMap.values().stream()
        .filter(Objects::nonNull)
        .filter(task -> task.getAssignee().equals(assigneeId))
        .toList();
    }

    @Override
    public List<TaskDto> getTaskByAssignor(UUID assignorId) {
        return taskMap.values().stream()
        .filter(Objects::nonNull)
        .filter(task -> task.getAssignor().equals(assignorId))
        .toList();
    }

    @Override 
    public List<TaskDto> getTasksWithTitleContaining(String keyword) {
        return taskMap.values().stream()
        .filter(Objects::nonNull)
        .filter(task -> task.getTitle().contains(keyword))
        .toList();
    }
}
