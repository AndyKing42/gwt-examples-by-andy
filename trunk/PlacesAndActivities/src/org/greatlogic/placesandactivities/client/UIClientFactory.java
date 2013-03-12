package org.greatlogic.placesandactivities.client;

import org.greatlogic.placesandactivities.client.view.PlacesAndActivitiesView;
import com.google.web.bindery.event.shared.EventBus;

public class UIClientFactory implements IClientFactory {
//--------------------------------------------------------------------------------------------------
private EventBus                _eventBus;
private PlacesAndActivitiesView _placesAndActivitiesView;
//--------------------------------------------------------------------------------------------------
@Override
public PlacesAndActivitiesView getPlacesAndActivitiesView() {
  if (_placesAndActivitiesView == null) {
    _placesAndActivitiesView = new PlacesAndActivitiesView();
    _placesAndActivitiesView.initialize(this);
  }
  return _placesAndActivitiesView;
} // getPlacesAndActivitiesView()
//--------------------------------------------------------------------------------------------------
@Override
public EventBus getEventBus() {
  return _eventBus;
} // getEventBus()
//--------------------------------------------------------------------------------------------------
@Override
public void initialize(final EventBus eventBus) {
  _eventBus = eventBus;
} // initialize()
//--------------------------------------------------------------------------------------------------
}