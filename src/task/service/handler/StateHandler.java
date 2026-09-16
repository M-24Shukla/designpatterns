package task.service.handler;

import task.domain.TaskDto;
import task.domain.TaskStatus;
import task.domain.user.IUser;
import task.service.taskstate.Completed;
import task.service.taskstate.Hold;
import task.service.taskstate.ITaskState;
import task.service.taskstate.InProgress;
import task.service.taskstate.Todo;

public class StateHandler extends WorkFlowHandler {

    public StateHandler() {
        this.handlerName = "TaskWorkFlow handler";
    }

    @Override
    public void handleTaskEvent(TaskDto taskDto, IUser user, TaskStatus toStatus) {
        ITaskState taskState = null;

        switch (taskDto.getCurrentStatus().toString()) {
            case "TODO":
                taskState = new Todo();
                break;
            case "IN_PROGRESS":
                taskState = new InProgress();
                break;
            case "HOLD":
                taskState = new Hold();
                break;
            case "COMPLETED":
                taskState = new Completed();
                break;

        }

        if (taskState == null) return;

        if (taskState.handleStatusChange(taskDto, user, toStatus)) {
            System.out.println("Task status change permitted");
            taskDto.setCurrentStatus(toStatus);
            if (handler != null) handler.handleTaskEvent(taskDto, user, toStatus);
        } else {
            System.err.println("Please verify the user rights");
        }
    }
}
