package org.greatlogic.placesandactivities.client.view.interfaces;

import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.ResizeLayoutPanel;

public interface ITopLevelView extends IsWidget {
//--------------------------------------------------------------------------------------------------
ResizeLayoutPanel getAppMenuPanel();
ResizeLayoutPanel getAppPanel();
Panel getTopLevelPanel();
ResizeLayoutPanel getWestPanel();
void initialize();
void setAppTitle(final String appTitle);
//--------------------------------------------------------------------------------------------------
}