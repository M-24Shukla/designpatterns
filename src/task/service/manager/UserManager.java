package task.service.manager;

import java.util.UUID;

import task.domain.user.IUser;
import task.repository.user.UserRepository;

public class UserManager {

    private final UserRepository repository;

    public UserManager(UserRepository repository) {
        this.repository = repository;
    }

    public IUser getUser(UUID userId) {
        return repository.getUser(userId);
    }

    public void addUser(IUser user) {
        repository.addUser(user);
    }

    public void deleteUser(UUID userId) {
        repository.deleteUser(userId);
    }

}
