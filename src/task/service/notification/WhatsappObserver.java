package task.service.notification;

public class WhatsappObserver implements NotificationObserver {

    @Override
    public void onNotificationEvent() {
        System.out.println("\n\n [WhatsApp] Initiating notification...");
    }
}
