package task.domain.user;

import java.util.UUID;

public interface IUser {

    public UserType getUserType();

    public String getName();

    public UUID getUserId();

}
