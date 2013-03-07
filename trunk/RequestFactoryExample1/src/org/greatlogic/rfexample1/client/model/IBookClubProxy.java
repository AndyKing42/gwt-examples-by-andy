package org.greatlogic.rfexample1.client.model;

import com.google.web.bindery.requestfactory.shared.EntityProxy;
import com.google.web.bindery.requestfactory.shared.ProxyFor;
import org.greatlogic.rfexample1.server.model.BookClub;
import org.greatlogic.rfexample1.server.model.BookClubLocator;

@ProxyFor(value = BookClub.class, locator = BookClubLocator.class)
public interface IBookClubProxy extends EntityProxy {
//--------------------------------------------------------------------------------------------------
String getDesc();
int getId();
String getModifiedDateTime();
String getModifiedUserId();
String getName();
int getVersion();
//--------------------------------------------------------------------------------------------------
void setDesc(final String desc);
void setId(final Integer id);
void setModifiedDateTime(final String modifiedDateTime);
void setModifiedUserId(final String modifiedUserId);
void setName(final String name);
void setVersion(final Integer version);
//--------------------------------------------------------------------------------------------------
}