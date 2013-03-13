package org.greatlogic.placesandactivities.client;

import org.greatlogic.placesandactivities.client.view.PlacesAndActivitiesView;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.web.bindery.event.shared.SimpleEventBus;

public class PlacesAndActivities implements EntryPoint {
//--------------------------------------------------------------------------------------------------
@Override
public void onModuleLoad() {
  final SimpleEventBus eventBus = new SimpleEventBus();
  final IClientFactory clientFactory = GWT.create(UIClientFactory.class);
  clientFactory.initialize(eventBus);
  final PlacesAndActivitiesView placesAndActivitiesView = new PlacesAndActivitiesView();
  placesAndActivitiesView.initialize(clientFactory);
  RootLayoutPanel.get().add(placesAndActivitiesView.getOuterPanel());
} // onModuleLoad()
//--------------------------------------------------------------------------------------------------
}