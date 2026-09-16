package task.service.taskstate;

import task.domain.TaskDto;
import task.domain.TaskStatus;
import task.domain.user.IUser;
import task.domain.user.UserType;

public class InProgress implements ITaskState {

    @Override
    public boolean handleStatusChange(TaskDto taskDto, IUser user, TaskStatus to) {
        if (TaskStatus.HOLD.equals(to)) {
            System.out.println("Changing the status from %s to %s".formatted(TaskStatus.IN_PROGRESS, to));
            return true;
        }

        if (TaskStatus.COMPLETED.equals(to) && !UserType.PM.equals(user.getUserType())) {
            System.err.println("User %s cannot change the status from %s to %s"
                            .formatted(user.getUserType(), taskDto.getCurrentStatus(), to));
            return false;
        }
        System.out.println("Changing the status of the task from %s to %s".formatted(taskDto.getCurrentStatus(), to));
        return true;
    }

    @Override 
    public String toString() {
        return "IN-PROGRESS HANDLER";
    }
}
