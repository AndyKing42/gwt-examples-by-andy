package org.greatlogic.placesandactivities.client.activity;

import org.greatlogic.placesandactivities.client.IClientFactory;
import org.greatlogic.placesandactivities.client.place.AppMenuPlace;
import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;

public class AppMenuActivityMapper implements ActivityMapper {

//--------------------------------------------------------------------------------------------------

private Activity       _appMenuActivity;
private IClientFactory _clientFactory;

//--------------------------------------------------------------------------------------------------

public static void initialize(final IClientFactory clientFactory) {
  ActivityMapper activityMapper = new AppMenuActivityMapper(clientFactory);
  ActivityManager activityManager = new ActivityManager(activityMapper, clientFactory.getEventBus());
  //  activityManager.setDisplay(clientFactory.getTopLevelView().getAppMenuPanel());
} // initialize()

//--------------------------------------------------------------------------------------------------

private AppMenuActivityMapper(final IClientFactory clientFactory) {
  super();
  _clientFactory = clientFactory;
} // AppMenuActivityMapper()

//--------------------------------------------------------------------------------------------------
@Override
public Activity getActivity(final Place place) {
  if (place instanceof AppMenuPlace) {
    _appMenuActivity = new AppMenuActivity((AppMenuPlace)place, _clientFactory);
  }
  return _appMenuActivity;
} // getActivity()

//--------------------------------------------------------------------------------------------------

}