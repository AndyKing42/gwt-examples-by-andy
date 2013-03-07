package org.greatlogic.rfexample2.shared;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("RequestFactoryExample")
public interface IRemoteService extends RemoteService {
//--------------------------------------------------------------------------------------------------
Integer login(final String userId, final String password);
//--------------------------------------------------------------------------------------------------
}