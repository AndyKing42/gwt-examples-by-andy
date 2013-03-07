package org.greatlogic.rfexample1.client;

import org.greatlogic.rfexample1.client.model.BookClubCache;
import org.greatlogic.rfexample1.client.view.BookClubMaintenanceView;
import com.google.web.bindery.event.shared.EventBus;

public class UIClientFactory implements IClientFactory {
//--------------------------------------------------------------------------------------------------
private BookClubCache           _bookClubCache;
private BookClubMaintenanceView _bookClubMaintenanceView;
private EventBus                _eventBus;
private IRequestFactory         _requestFactory;
//--------------------------------------------------------------------------------------------------
@Override
public BookClubCache getBookClubCache() {
  return _bookClubCache;
} // getBookClubCache()
//--------------------------------------------------------------------------------------------------
@Override
public BookClubMaintenanceView getBookClubMaintenanceView() {
  if (_bookClubMaintenanceView == null) {
    _bookClubMaintenanceView = new BookClubMaintenanceView();
    _bookClubMaintenanceView.initialize(this);
  }
  return _bookClubMaintenanceView;
} // getBookClubMaintenanceView()
//--------------------------------------------------------------------------------------------------
@Override
public IRequestFactory getRequestFactory() {
  return _requestFactory;
} // getRequestFactory()
//--------------------------------------------------------------------------------------------------
@Override
public EventBus getEventBus() {
  return _eventBus;
} // getEventBus()
//--------------------------------------------------------------------------------------------------
@Override
public void initialize(final EventBus eventBus, final IRequestFactory requestFactory,
                       final BookClubCache bookClubCache) {
  _eventBus = eventBus;
  _requestFactory = requestFactory;
  _bookClubCache = bookClubCache;
} // initialize()
//--------------------------------------------------------------------------------------------------
}