package org.greatlogic.rfexample1.shared;

import java.util.List;
import org.greatlogic.rfexample1.client.model.IBookClubProxy;
import org.greatlogic.rfexample1.server.model.BookClubDAOLocator;
import org.greatlogic.rfexample1.server.model.IBookClubDAO;
import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.Service;

@Service(value = IBookClubDAO.class, locator = BookClubDAOLocator.class)
public interface IBookClubRequestContext extends RequestContext {
//--------------------------------------------------------------------------------------------------
Request<IBookClubProxy> findById(final Integer id);
Request<Void> save(final IBookClubProxy bookClub);
Request<List<IBookClubProxy>> selectAllBookClubs();
//--------------------------------------------------------------------------------------------------
}