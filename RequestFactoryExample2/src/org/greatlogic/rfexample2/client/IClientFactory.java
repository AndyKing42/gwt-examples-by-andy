package org.greatlogic.rfexample2.client;

import com.google.web.bindery.event.shared.EventBus;
import org.greatlogic.rfexample2.client.cache.BookClubCache;
import org.greatlogic.rfexample2.client.view.BookClubMaintenanceView;
import org.greatlogic.rfexample2.shared.IRemoteServiceAsync;

public interface IClientFactory {
//--------------------------------------------------------------------------------------------------
BookClubCache getBookClubCache();
BookClubMaintenanceView getBookClubMaintenanceView();
EventBus getEventBus();
IRemoteServiceAsync getRemoteServiceAsync();
IRequestFactory getRequestFactory();
RequestFactoryResender getRequestFactoryResender();
void initialize(final EventBus eventBus, final IRemoteServiceAsync remoteServiceAsync,
                final IRequestFactory requestFactory, final BookClubCache bookClubCache);
void login();
void setRequestFactoryResender(final RequestFactoryResender requestFactoryResender);
//--------------------------------------------------------------------------------------------------
}