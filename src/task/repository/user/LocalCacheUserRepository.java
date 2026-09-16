package task.repository.user;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import task.domain.user.IUser;

public class LocalCacheUserRepository implements UserRepository {

    private final ConcurrentHashMap<UUID, IUser> userMap = new ConcurrentHashMap<>();

    @Override
    public IUser getUser(UUID userId) {
        IUser response = userMap.get(userId);
        if (response == null) {
            System.err.println("The user with ID %s does not exist".formatted(userId));
            return null;
        }
        // System.out.println("Returning user %s...".formatted(response));
        return response;
    }

    @Override
    public void addUser(IUser user) {
        if (userMap.get(user.getUserId()) != null) {
            System.err.println("User %s already exists.".formatted(user));
            return;
        }
        System.out.println("Adding user %s...".formatted(user));
        userMap.put(user.getUserId(), user);
    }

    @Override
    public void deleteUser(UUID userId) {
        if (userMap.get(userId) == null) {
            System.err.println("User with ID %s does not exists.".formatted(userId));
            return;
        }
        System.out.println("Deleting user %s...".formatted(userMap.remove(userId)));
    }

}
