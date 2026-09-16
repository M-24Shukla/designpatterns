package task.service.handler;

import task.domain.TaskDto;
import task.domain.TaskStatus;
import task.domain.user.IUser;

public abstract class WorkFlowHandler {

    protected WorkFlowHandler handler;

    protected String handlerName;

    public void setNext(WorkFlowHandler handler) {
        this.handler = handler;
    }

    abstract public void handleTaskEvent(TaskDto taskDto, IUser userId, TaskStatus toStatus);

    public String getHandlerName() {
        return this.handlerName;
    }
}
