package org.greatlogic.rfexample2.client;

import org.greatlogic.rfexample2.shared.IBookClubRequestContext;
import org.greatlogic.rfexample2.shared.IUserRequestContext;
import com.google.web.bindery.requestfactory.shared.RequestFactory;

public interface IRequestFactory extends RequestFactory {
//--------------------------------------------------------------------------------------------------
IBookClubRequestContext newBookClubRequestContext();
IUserRequestContext newUserRequestContext();
//--------------------------------------------------------------------------------------------------
}