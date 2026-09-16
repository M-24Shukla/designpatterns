package task.domain.user;

import java.util.UUID;

public class ProductManager implements IUser {
    private final UserType type = UserType.PM;

    private final UUID userId = UUID.randomUUID();

    private final String name;

    public ProductManager(String name) {
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
        return "ProductManager [type=" + type + ", userId=" + userId + ", name=" + name + "]";
    }
}
