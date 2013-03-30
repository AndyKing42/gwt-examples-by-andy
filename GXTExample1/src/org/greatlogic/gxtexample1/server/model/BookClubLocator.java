package org.greatlogic.gxtexample1.server.model;

import com.google.web.bindery.requestfactory.shared.Locator;

public class BookClubLocator extends Locator<BookClub, Integer> {
//--------------------------------------------------------------------------------------------------
@Override
public BookClub create(final Class<? extends BookClub> clazz) {
  return new BookClub();
} // create()
//--------------------------------------------------------------------------------------------------
@Override
public BookClub find(final Class<? extends BookClub> clazz, final Integer id) {
  return BookClubDAOLocator.getBookClubDAO().findById(id);
} // find()
//--------------------------------------------------------------------------------------------------
@Override
public Class<BookClub> getDomainType() {
  return BookClub.class;
} // getDomainType()
//--------------------------------------------------------------------------------------------------
@Override
public Integer getId(final BookClub domainObject) {
  return domainObject.getId();
} // getId()
//--------------------------------------------------------------------------------------------------
@Override
public Class<Integer> getIdType() {
  return Integer.class;
} // getIdType()
//--------------------------------------------------------------------------------------------------
@Override
public Object getVersion(final BookClub domainObject) {
  return domainObject.getVersion();
} // getVersion()
//--------------------------------------------------------------------------------------------------
}