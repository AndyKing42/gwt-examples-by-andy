package org.greatlogic.gxtexample1.client;

import org.greatlogic.gxtexample1.client.model.BookClubCache;
import org.greatlogic.gxtexample1.client.view.BookClubMaintenanceView;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.web.bindery.event.shared.SimpleEventBus;

public class GXTExample1 implements EntryPoint {
//--------------------------------------------------------------------------------------------------
@Override
public void onModuleLoad() {
  final SimpleEventBus eventBus = new SimpleEventBus();
  final IRequestFactory requestFactory = GWT.create(IRequestFactory.class);
  requestFactory.initialize(eventBus);
  final BookClubCache bookClubCache = new BookClubCache();
  final IClientFactory clientFactory = GWT.create(UIClientFactory.class);
  clientFactory.initialize(eventBus, requestFactory, bookClubCache);
  bookClubCache.initialize(clientFactory);
  final BookClubMaintenanceView bookClubMaintenanceView = new BookClubMaintenanceView();
  bookClubMaintenanceView.initialize(clientFactory);
  RootLayoutPanel.get().add(bookClubMaintenanceView.getTopLevelContainer());
} // onModuleLoad()
//--------------------------------------------------------------------------------------------------
}