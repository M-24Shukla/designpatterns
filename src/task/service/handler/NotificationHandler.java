package task.service.handler;

import task.domain.TaskDto;
import task.domain.TaskStatus;
import task.domain.user.IUser;
import task.service.notification.NotificationPublisher;

public class NotificationHandler extends WorkFlowHandler {

    private final NotificationPublisher publisher;

    public NotificationHandler(NotificationPublisher publisher) {
        this.publisher = publisher;
    }

    @Override
    public void handleTaskEvent(TaskDto taskDto, IUser userId, TaskStatus toStatus) {
        String notificationMessage = "%s initiated the status change of task %s from %s to %s"
        .formatted(userId.getName(), taskDto.getTitle(), taskDto.getCurrentStatus(), toStatus);

        publisher.initiateNotification(notificationMessage);

    }

}
