package task.service.notification;

public class EmailObserver implements NotificationObserver {

    @Override
    public void onNotificationEvent() {
        System.out.println("\n\n [Email] Initiating notification...");
    }

}
