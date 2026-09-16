package task.service.notification;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class NotificationPublisher {

    private final Set<NotificationObserver> observers = new HashSet<>();

    public void subscribe(NotificationObserver observer) {
        observers.add(observer);
    }

    public void unsubscribe(NotificationObserver observer) {
        observers.remove(observer);
    }

    public void initiateNotification(String message) {
        System.out.println("Sending notification about the event: " + message);
        observers.forEach(NotificationObserver::onNotificationEvent);
    }
    
}
