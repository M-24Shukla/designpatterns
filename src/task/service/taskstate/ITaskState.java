package task.service.taskstate;

import task.domain.TaskDto;
import task.domain.TaskStatus;
import task.domain.user.IUser;

public interface ITaskState {

    public boolean handleStatusChange(TaskDto taskDto, IUser user, TaskStatus to);
}
