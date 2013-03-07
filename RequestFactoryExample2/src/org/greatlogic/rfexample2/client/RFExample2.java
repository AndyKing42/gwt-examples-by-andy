package org.greatlogic.rfexample2.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.Window.ClosingEvent;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.web.bindery.event.shared.SimpleEventBus;
import org.greatlogic.rfexample2.client.cache.BookClubCache;
import org.greatlogic.rfexample2.client.view.BookClubMaintenanceView;
import org.greatlogic.rfexample2.shared.IRemoteService;
import org.greatlogic.rfexample2.shared.IRemoteServiceAsync;

public class RFExample2 implements EntryPoint {
//--------------------------------------------------------------------------------------------------
@Override
public void onModuleLoad() {
  SimpleEventBus eventBus = new SimpleEventBus();
  IRemoteServiceAsync remoteServiceAsync = (IRemoteServiceAsync)GWT.create(IRemoteService.class);
  IRequestFactory requestFactory = GWT.create(IRequestFactory.class);
  requestFactory.initialize(eventBus, new RFERequestTransport());
  BookClubCache bookClubCache = new BookClubCache();
  IClientFactory clientFactory = GWT.create(UIClientFactory.class);
  clientFactory.initialize(eventBus, remoteServiceAsync, requestFactory, bookClubCache);
  bookClubCache.initialize(clientFactory);
  Window.addWindowClosingHandler(new Window.ClosingHandler() {
    @Override
    public void onWindowClosing(final ClosingEvent event) {
      event.setMessage("Is it okay to close?");
    } // onWindowClosing()
  });
  BookClubMaintenanceView bookClubMaintenanceView = new BookClubMaintenanceView();
  bookClubMaintenanceView.initialize(clientFactory);
  RootLayoutPanel.get().add(bookClubMaintenanceView.getTopLevelPanel());
} // onModuleLoad()
//--------------------------------------------------------------------------------------------------
}