package org.greatlogic.placesandactivities.client.view;

import org.greatlogic.placesandactivities.client.IClientFactory;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.SimpleLayoutPanel;
import com.google.gwt.user.client.ui.Widget;

public class PlacesAndActivitiesView extends Composite {
//--------------------------------------------------------------------------------------------------
@UiField
SimpleLayoutPanel      outerPanel;

private IClientFactory _clientFactory;
//==================================================================================================
public interface IPlacesAndActivitiesViewUiBinder extends UiBinder<Widget, PlacesAndActivitiesView> { //
} // interface IPlacesAndActivitiesViewUiBinder
//==================================================================================================
public SimpleLayoutPanel getOuterPanel() {
  return outerPanel;
} // getOuterPanel()
//--------------------------------------------------------------------------------------------------
public void initialize(final IClientFactory clientFactory) {
  _clientFactory = clientFactory;
  IPlacesAndActivitiesViewUiBinder binder = GWT.create(IPlacesAndActivitiesViewUiBinder.class);
  binder.createAndBindUi(this);
} // initialize()
//--------------------------------------------------------------------------------------------------
}