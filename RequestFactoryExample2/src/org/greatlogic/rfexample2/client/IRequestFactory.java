package org.greatlogic.rfexample2.client;

import com.google.web.bindery.requestfactory.shared.RequestFactory;
import org.greatlogic.rfexample2.shared.IBookClubRequestContext;
import org.greatlogic.rfexample2.shared.IUserRequestContext;

public interface IRequestFactory extends RequestFactory {
//--------------------------------------------------------------------------------------------------
IBookClubRequestContext newBookClubRequestContext();
IUserRequestContext newUserRequestContext();
//--------------------------------------------------------------------------------------------------
}