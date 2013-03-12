package org.greatlogic.placesandactivities.client;

public final class PlacesAndActivitiesEnums {
//--------------------------------------------------------------------------------------------------
public enum EApp {
OrgMaintenance("Organization Maintenance"),
PetMaintenance("Pet Maintenance");
private String _appTitle;
private EApp(final String appTitle) {
  _appTitle = appTitle;
} // EApp()
public String getAppTitle() {
  return _appTitle;
} // getAppTitle()
} // enum EApp
//--------------------------------------------------------------------------------------------------
private PlacesAndActivitiesEnums() {
  // prevent instantiation
} // PlacesAndActivitiesEnums
//--------------------------------------------------------------------------------------------------
}