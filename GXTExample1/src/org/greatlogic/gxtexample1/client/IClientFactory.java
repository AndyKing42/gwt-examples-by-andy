package org.greatlogic.gxtexample1.client;

import org.greatlogic.gxtexample1.client.model.BookClubCache;
import org.greatlogic.gxtexample1.client.view.BookClubMaintenanceView;
import com.google.web.bindery.event.shared.EventBus;

public interface IClientFactory {
//--------------------------------------------------------------------------------------------------
BookClubCache getBookClubCache();
EventBus getEventBus();
BookClubMaintenanceView getBookClubMaintenanceView();
IRequestFactory getRequestFactory();
void initialize(final EventBus eventBus, final IRequestFactory requestFactory,
                final BookClubCache bookClubCache);
//--------------------------------------------------------------------------------------------------
}