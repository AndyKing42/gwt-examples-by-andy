package org.greatlogic.placesandactivities.client.view.interfaces;

import org.greatlogic.placesandactivities.client.IClientFactory;
import org.greatlogic.placesandactivities.client.activity.AppMenuActivity;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.MenuBar;

public interface IAppMenuView extends IsWidget {
//--------------------------------------------------------------------------------------------------
public interface IPresenter {
void goTo(final Place place, final EApp app);
} // interface IPresenter
//--------------------------------------------------------------------------------------------------
MenuBar getMenuBar();
void initialize(final IClientFactory clientFactory);
void setAppMenuActivity(final AppMenuActivity appMenuActivity);
//--------------------------------------------------------------------------------------------------
}