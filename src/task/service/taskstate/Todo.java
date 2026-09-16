package task.service.taskstate;

import task.domain.TaskDto;
import task.domain.TaskStatus;
import task.domain.user.IUser;
import task.domain.user.UserType;

public class Todo implements ITaskState {

    @Override
    public boolean handleStatusChange(TaskDto taskDto, IUser user, TaskStatus to) {
        if (UserType.DEV.equals(user.getUserType()) && TaskStatus.IN_PROGRESS.equals(to)) {
            System.out.println("Changing the task status from TODO to %s".formatted(to));
            return true;
        }
        System.err.println("%s cannot change the status from TODO to %s".formatted(user.getUserType(), to));
        return false;
    }

    
    @Override 
    public String toString() {
        return "TODO HANDLER";
    }
    
}
