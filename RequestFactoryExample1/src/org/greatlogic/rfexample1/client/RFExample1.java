package org.greatlogic.rfexample1.client;

import org.greatlogic.rfexample1.client.model.BookClubCache;
import org.greatlogic.rfexample1.client.view.BookClubMaintenanceView;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.web.bindery.event.shared.SimpleEventBus;

public class RFExample1 implements EntryPoint {
//--------------------------------------------------------------------------------------------------
@Override
public void onModuleLoad() {
  SimpleEventBus eventBus = new SimpleEventBus();
  IRequestFactory requestFactory = GWT.create(IRequestFactory.class);
  requestFactory.initialize(eventBus);
  BookClubCache bookClubCache = new BookClubCache();
  IClientFactory clientFactory = GWT.create(UIClientFactory.class);
  clientFactory.initialize(eventBus, requestFactory, bookClubCache);
  bookClubCache.initialize(clientFactory);
  BookClubMaintenanceView bookClubMaintenanceView = new BookClubMaintenanceView();
  bookClubMaintenanceView.initialize(clientFactory);
  RootLayoutPanel.get().add(bookClubMaintenanceView.getTopLevelPanel());
} // onModuleLoad()
//--------------------------------------------------------------------------------------------------
}