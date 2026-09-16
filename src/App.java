import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import task.domain.TaskDto;
import task.domain.TaskStatus;
import task.domain.user.Developer;
import task.domain.user.IUser;
import task.domain.user.ProductManager;
import task.repository.task.LocalCacheTaskRepository;
import task.repository.task.TaskRepository;
import task.repository.user.LocalCacheUserRepository;
import task.repository.user.UserRepository;
import task.service.handler.AuthHandler;
import task.service.handler.NotificationHandler;
import task.service.handler.StateHandler;
import task.service.manager.TaskManager;
import task.service.manager.UserManager;
import task.service.notification.EmailObserver;
import task.service.notification.NotificationPublisher;
import task.service.notification.WhatsappObserver;

public class App {
    public static void main(String[] args) {

        /////////////////// Session Warmup Begin /////////////////// 
        
        // Initializing repositories
        UserRepository userRepo = new LocalCacheUserRepository();
        TaskRepository taskRepo = new LocalCacheTaskRepository();

        // Initializing Notifiers and subscribing observers
        NotificationPublisher notificationPublisher = new NotificationPublisher();
        notificationPublisher.subscribe(new EmailObserver());
        notificationPublisher.subscribe(new WhatsappObserver());

        // Initializing task workflow child handler
        AuthHandler authHandler = new AuthHandler();
        StateHandler stateHandler = new StateHandler();
        NotificationHandler notificationHandler = new NotificationHandler(notificationPublisher);
        
        // Wiring up handlers
        authHandler.setNext(stateHandler);
        stateHandler.setNext(notificationHandler);

        // Initializing User Manager
        UserManager userManager = new UserManager(userRepo);

        // Initializing task manager
        TaskManager taskManager = new TaskManager(taskRepo, userManager, authHandler);

        /////////////////// Session Warmup End /////////////////// 

        /////////////////// User Creation Begin /////////////////// 

        // Creating PMs
        ProductManager me = new ProductManager("Mayank Shukla");
        ProductManager didi = new ProductManager("Swadha Shukla");
        ProductManager baby = new ProductManager("Divya Kumari");
        ProductManager ashu = new ProductManager("Ashutosh Sarkar");
        ProductManager umang = new ProductManager("Umang Gupta");

        // Creating Devs
        Developer hizru = new Developer("Hizru");
        Developer nazma = new Developer("Nazma");
        Developer guard = new Developer("Alexandar");
        
        System.out.println("\n===============\nOnboarding Users\n===============");
        Stream.of(me, didi, baby, ashu, umang, hizru, nazma, guard).forEach(user -> {
            try {
                TimeUnit.MILLISECONDS.sleep(200);
            } catch (Exception e) {
                // TODO: handle exception
            }
            userManager.addUser(user);
        });

        /////////////////// User Creation End /////////////////// 


        /////////////////// Task Creation Begin ///////////////////
        
        TaskDto zaadu = new TaskDto("Brush the house", hizru.getUserId(), me.getUserId());
        TaskDto makeChai = new TaskDto("Prepare 4 cup chai", nazma.getUserId(), baby.getUserId());
        TaskDto makeParatha = new TaskDto("Make 8 paratha", nazma.getUserId(), ashu.getUserId());
        TaskDto litSutta = new TaskDto("Lit 1 Classic Mild", me.getUserId(), umang.getUserId());
        TaskDto openbackGate = new TaskDto("Open Back Gate", guard.getUserId(), me.getUserId());
        System.out.println("\n===============\nCreating tasks\n===============");
        Stream.of(zaadu, makeChai, makeParatha, litSutta, openbackGate).forEach(task -> {
            try {
                TimeUnit.MILLISECONDS.sleep(200);
            } catch (Exception e) {
                // TODO: handle exception
            }
            taskManager.addTask(task);
        });
        /////////////////// Task Creation End /////////////////// 

        /////////////////// Operations start /////////////////// 
        
        System.out.println("===============");
        System.out.println("Doing operations on %s".formatted(me));
        taskManager.getTasksAssignedToUser(me.getUserId()).forEach(task -> 
            System.out.println("%s assigned to %s by %s"
            .formatted(task.getTitle(), me.getName(), userManager.getUser(task.getAssignor()).getName()))
        );
        System.out.println("===============");
        taskManager.getTasksAssignor(me.getUserId()).forEach(task -> {
            System.out.println("%s assigned by %s to %s"
            .formatted(task.getTitle(), me.getName(), userManager.getUser(task.getAssignee()).getName()));

        }
        );;

        System.out.println("===============");
        System.out.println("Doing operations on %s".formatted(zaadu));
        System.out.println("===============");
        taskManager.changeStatus(zaadu.getTaskId(), hizru.getUserId(), TaskStatus.IN_PROGRESS);
        taskManager.changeStatus(zaadu.getTaskId(), hizru.getUserId(), TaskStatus.COMPLETED);
        taskManager.changeStatus(zaadu.getTaskId(), nazma.getUserId(), TaskStatus.COMPLETED);

        System.out.println("===============");
        /////////////////// Operations End ////////////////////
    }
}
