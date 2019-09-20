package distributed.transaction.mappers;

import distributed.transaction.model.User;

/**
 * @author Dean
 */
public interface UserMapper {

	Integer save(User user);
}
