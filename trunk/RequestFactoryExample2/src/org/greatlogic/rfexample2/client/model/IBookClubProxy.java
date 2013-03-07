package org.greatlogic.rfexample2.client.model;

import com.google.web.bindery.requestfactory.shared.EntityProxy;
import com.google.web.bindery.requestfactory.shared.ProxyFor;
import org.greatlogic.rfexample2.server.model.dto.BookClub;
import org.greatlogic.rfexample2.server.model.dto.BookClubLocator;

@ProxyFor(value = BookClub.class, locator = BookClubLocator.class)
public interface IBookClubProxy extends EntityProxy {
//--------------------------------------------------------------------------------------------------
String getBookClubDesc();
String getBookClubName();
int getId();
String getModifiedDateTime();
String getModifiedUserId();
int getVersion();
//--------------------------------------------------------------------------------------------------
void setBookClubDesc(final String bookClubDesc);
void setBookClubName(final String bookClubName);
void setId(final Integer id);
void setModifiedDateTime(final String modifiedDateTime);
void setModifiedUserId(final String modifiedUserId);
void setVersion(final Integer version);
//--------------------------------------------------------------------------------------------------
}