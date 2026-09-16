package task.repository.user;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import task.domain.user.IUser;

public interface UserRepository {

    public IUser getUser(UUID userId);

    public void addUser(IUser user);

    public void deleteUser(UUID userId);
}
