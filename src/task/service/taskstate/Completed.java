package task.service.taskstate;

import task.domain.TaskDto;
import task.domain.TaskStatus;
import task.domain.user.IUser;

public class Completed implements ITaskState {

    @Override
    public boolean handleStatusChange(TaskDto taskDto, IUser user, TaskStatus to) {
        if (TaskStatus.TODO.equals(to)) {
            System.out.println("Changing the task status %s".formatted(to));
            return true;
        }
        System.err.println("Cannot change the status to %s".formatted(to));
        return false;
    }

    
    @Override 
    public String toString() {
        return "COMPLETED HANDLER";
    }

}
