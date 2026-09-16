package task.domain.user;

import java.util.UUID;

public class Developer implements IUser {

    private final UserType type = UserType.DEV;

    private final UUID userId = UUID.randomUUID();

    private final String name;

    public Developer(String name) {
        this.name = name;
    }

    @Override
    public UserType getUserType() {
        return this.type;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public UUID getUserId() {
        return this.userId;
    }

    @Override
    public String toString() {
        return "Developer [type=" + type + ", userId=" + userId + ", name=" + name + "]";
    }
    
    
}
