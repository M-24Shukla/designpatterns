package task.repository.task;

import java.util.List;
import java.util.UUID;

import task.domain.TaskDto;

public interface TaskRepository {

    public void addTask(TaskDto taskDto);

    public TaskDto getTask(UUID taskId);

    public List<TaskDto> getTaskByAssignee(UUID assigneeId);

    public List<TaskDto> getTaskByAssignor(UUID assignorId);

    public List<TaskDto> getTasksWithTitleContaining(String keyword);
}
