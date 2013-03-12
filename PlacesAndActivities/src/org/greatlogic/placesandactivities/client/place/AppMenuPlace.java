package org.greatlogic.placesandactivities.client.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class AppMenuPlace extends Place {
//--------------------------------------------------------------------------------------------------
private final String _token;
//==================================================================================================
public static class Tokenizer implements PlaceTokenizer<AppMenuPlace> {
//--------------------------------------------------------------------------------------------------
@Override
public AppMenuPlace getPlace(final String token) {
  return new AppMenuPlace(token);
} // getPlace()
//--------------------------------------------------------------------------------------------------
@Override
public String getToken(final AppMenuPlace place) {
  return place.getToken();
} // getToken()
//--------------------------------------------------------------------------------------------------
} // class Tokenizer
//==================================================================================================
public AppMenuPlace(final String token) {
  _token = token;
} // AppMenuPlace()
//--------------------------------------------------------------------------------------------------
public String getToken() {
  return _token;
} // getToken()
//--------------------------------------------------------------------------------------------------
}