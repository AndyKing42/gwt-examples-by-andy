package org.greatlogic.gxtexample1.client;

import com.google.web.bindery.requestfactory.shared.RequestFactory;
import org.greatlogic.gxtexample1.shared.IBookClubRequestContext;

public interface IRequestFactory extends RequestFactory {
//--------------------------------------------------------------------------------------------------
IBookClubRequestContext newBookClubRequestContext();
//--------------------------------------------------------------------------------------------------
}