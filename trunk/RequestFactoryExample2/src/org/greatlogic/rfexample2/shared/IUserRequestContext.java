package org.greatlogic.rfexample2.shared;

import java.util.List;
import org.greatlogic.rfexample2.client.model.IUserProxy;
import org.greatlogic.rfexample2.server.model.dao.IUserDAO;
import org.greatlogic.rfexample2.server.model.dao.UserDAOLocator;
import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.Service;

@Service(value = IUserDAO.class, locator = UserDAOLocator.class)
public interface IUserRequestContext extends RequestContext {
//--------------------------------------------------------------------------------------------------
Request<IUserProxy> findById(final Integer id);
Request<IUserProxy> findByUserIdAndPassword(final String userId, final String password);
Request<Integer> save(final IUserProxy user);
Request<List<IUserProxy>> selectAllUsers();
//--------------------------------------------------------------------------------------------------
}