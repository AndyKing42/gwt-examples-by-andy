package org.greatlogic.rfexample2.client.view.interfaces;

import org.greatlogic.rfexample2.client.IClientFactory;
import com.google.gwt.user.client.ui.HeaderPanel;
import com.google.gwt.user.client.ui.IsWidget;

public interface IOrgMaintenanceView extends IsWidget {
//--------------------------------------------------------------------------------------------------
HeaderPanel getTopLevelPanel();
void initialize(final IClientFactory clientFactory);
//--------------------------------------------------------------------------------------------------
}