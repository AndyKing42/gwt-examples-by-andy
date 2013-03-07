package org.greatlogic.rfexample2.shared;

import java.util.List;
import org.greatlogic.rfexample2.client.model.IBookClubProxy;
import org.greatlogic.rfexample2.server.model.dao.BookClubDAOLocator;
import org.greatlogic.rfexample2.server.model.dao.IBookClubDAO;
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