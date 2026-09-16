package task.service.handler;

import task.domain.TaskDto;
import task.domain.TaskStatus;
import task.domain.user.IUser;

public class AuthHandler extends WorkFlowHandler{

    public AuthHandler() {
        handlerName = "TaskOwnershipHandler";
    }

    @Override
    public void handleTaskEvent(TaskDto taskDto, IUser user, TaskStatus toStatus) {
        
        if (user.getUserId().equals(taskDto.getAssignee()) || user.getUserId().equals(taskDto.getAssignor())) {
            System.out.println("User %s can make changes in the story: %s.".formatted(user.getName(), taskDto.getTitle()));
        } else {
            System.out.println("User %s is not authenticated to make changes in the task %s. Rejecting the request".formatted(user.getName(), taskDto.getTitle()));
            return;
        }

        if (handler != null) {
            System.out.println("This task will now be passed to: %s".formatted(handlerName));
            handler.handleTaskEvent(taskDto, user, toStatus);
        }
    }

}
