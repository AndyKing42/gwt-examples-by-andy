package org.greatlogic.placesandactivities.client.activity;

import org.greatlogic.placesandactivities.client.IClientFactory;
import org.greatlogic.placesandactivities.client.PlacesAndActivitiesEnums.EApp;
import org.greatlogic.placesandactivities.client.place.AppMenuPlace;
import org.greatlogic.placesandactivities.client.view.interfaces.IAppMenuView;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.ResizeLayoutPanel;
import com.google.web.bindery.event.shared.EventBus;

public class AppMenuActivity extends APAbstractActivity implements IAppMenuView.IPresenter {
//--------------------------------------------------------------------------------------------------
private final IAppMenuView   _appMenuView;
private final IClientFactory _clientFactory;
//--------------------------------------------------------------------------------------------------
/**
 * @param place This is the Place object that triggered this activity.
 */
public AppMenuActivity(final AppMenuPlace place, final IClientFactory clientFactory) {
  _clientFactory = clientFactory;
  _clientFactory.getAppMenuView().setAppMenuActivity(this);
} // AppMenuActivity()
//--------------------------------------------------------------------------------------------------
@Override
public void goTo(final Place place, final EApp app) {
  _clientFactory.getTopLevelView().setAppTitle(app.getAppTitle());
  _clientFactory.getPlaceController().goTo(place);
} // goto()
//--------------------------------------------------------------------------------------------------
@Override
public void onStop() {
  _clientFactory.getAppMenuView().setAppMenuActivity(null);
} // onStop()
//--------------------------------------------------------------------------------------------------
@Override
public void start(final AcceptsOneWidget panel, final EventBus eventBus) {
  _appMenuView = _clientFactory.getAppMenuView();
  ResizeLayoutPanel appMenuPanel = _clientFactory.getTopLevelView().getAppMenuPanel();
  appMenuPanel.setWidget(_appMenuView.asWidget());
  _appMenuView.setAppMenuActivity(this);
} // start()
//--------------------------------------------------------------------------------------------------
}