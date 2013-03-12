package org.greatlogic.placesandactivities.client;

import org.greatlogic.placesandactivities.client.view.PlacesAndActivitiesView;
import com.google.web.bindery.event.shared.EventBus;

public interface IClientFactory {
//--------------------------------------------------------------------------------------------------
PlacesAndActivitiesView getPlacesAndActivitiesView();
EventBus getEventBus();
void initialize(final EventBus eventBus);
//--------------------------------------------------------------------------------------------------
}