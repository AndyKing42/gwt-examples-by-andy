package org.greatlogic.placesandactivities.client.activity;

import org.fosterapet.client.IClientFactory;
import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.web.bindery.event.shared.EventBus;

public class WestActivityMapper extends APAbstractActivity implements ActivityMapper {

//--------------------------------------------------------------------------------------------------

private IClientFactory _clientFactory;

//--------------------------------------------------------------------------------------------------

public static void initialize(final IClientFactory clientFactory) {
  ActivityMapper activityMapper = new WestActivityMapper(clientFactory);
  ActivityManager activityManager = new ActivityManager(activityMapper, clientFactory.getEventBus());
  activityManager.setDisplay(clientFactory.getTopLevelView().getWestPanel());
} // initialize()

//--------------------------------------------------------------------------------------------------

private WestActivityMapper(final IClientFactory clientFactory) {
  super();
  _clientFactory = clientFactory;
} // WestActivityMapper()

//--------------------------------------------------------------------------------------------------
@Override
public Activity getActivity(final Place place) {
  return null;
} // getActivity()

//--------------------------------------------------------------------------------------------------
@Override
public void start(final AcceptsOneWidget panel, final EventBus eventBus) {
  //
} // start()

//--------------------------------------------------------------------------------------------------

}