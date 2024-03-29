package org.greatlogic.rfexample2.server.model.dao;

import java.util.List;
import org.greatlogic.rfexample2.server.model.dto.User;

public interface IUserDAO {
//--------------------------------------------------------------------------------------------------
public User findById(final Integer id);
public User findByUserIdAndPassword(final String userId, final String password);
public Integer save(final User user);
public List<User> selectAllUsers();
//--------------------------------------------------------------------------------------------------
}