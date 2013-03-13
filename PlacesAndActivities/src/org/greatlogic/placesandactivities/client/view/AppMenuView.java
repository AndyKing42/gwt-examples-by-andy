package org.greatlogic.placesandactivities.client.view;

import org.greatlogic.placesandactivities.client.IClientFactory;
import org.greatlogic.placesandactivities.client.activity.AppMenuActivity;
import org.greatlogic.placesandactivities.client.view.interfaces.IAppMenuView;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.Scheduler.ScheduledCommand;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.MenuBar;
import com.google.gwt.user.client.ui.MenuItem;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.ResizeLayoutPanel;

public class AppMenuView extends Composite implements IAppMenuView {
//--------------------------------------------------------------------------------------------------
@UiField
MenuItem                petMaintenanceMenuItem;
@UiField
MenuBar                 menuBar;
@UiField
ResizeLayoutPanel       menuPanel;
@UiField
MenuItem                orgMaintenanceMenuItem;
private AppMenuActivity _appMenuActivity;
//--------------------------------------------------------------------------------------------------
interface IAppMenuViewUiBinder extends UiBinder<Panel, AppMenuView> { //
} // interface IAppMenuViewUiBinder
//--------------------------------------------------------------------------------------------------
@Override
public MenuBar getMenuBar() {
  return menuBar;
} // getMenuBar()
//--------------------------------------------------------------------------------------------------
@Override
public void initialize(final IClientFactory clientFactory) {
  IAppMenuViewUiBinder binder = GWT.create(IAppMenuViewUiBinder.class);
  binder.createAndBindUi(this);
  initializeMenuItems();
  initWidget(menuPanel);
} // initialize()
//--------------------------------------------------------------------------------------------------
private void initializeMenuItems() {
  petMaintenanceMenuItem.setScheduledCommand(new ScheduledCommand() {
    @Override
    public void execute() {
      if (_appMenuActivity != null) {
        //        _appMenuActivity.goTo(new PetMaintenancePlace("pet"), EApp.PetMaintenance);
      }
    } // execute()
  });
  orgMaintenanceMenuItem.setScheduledCommand(new ScheduledCommand() {
    @Override
    public void execute() {
      if (_appMenuActivity != null) {
        //        _appMenuActivity.goTo(new OrgMaintenancePlace("org"), EApp.OrgMaintenance);
      }
    } // execute()
  });
} // initializeMenuItems()
//--------------------------------------------------------------------------------------------------
@Override
public void setAppMenuActivity(final AppMenuActivity appMenuActivity) {
  _appMenuActivity = appMenuActivity;
} // setAppMenuActivity()
//--------------------------------------------------------------------------------------------------
}