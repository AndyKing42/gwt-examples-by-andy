package org.greatlogic.rfexample1.server.model;

import com.google.web.bindery.requestfactory.shared.ServiceLocator;

public class BookClubDAOLocator implements ServiceLocator {
//--------------------------------------------------------------------------------------------------
static IBookClubDAO getBookClubDAO() {
  return TestBookClubDAO.getInstance();
} // getBookClubDAO()
//--------------------------------------------------------------------------------------------------
@Override
public IBookClubDAO getInstance(final Class<?> clazz) {
  return getBookClubDAO();
} // getInstance()
//--------------------------------------------------------------------------------------------------
}