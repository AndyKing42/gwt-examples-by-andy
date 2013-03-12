package org.greatlogic.placesandactivities.client.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class WestPlace extends Place {
//--------------------------------------------------------------------------------------------------
private final String _token;
//==================================================================================================
public static class Tokenizer implements PlaceTokenizer<WestPlace> {
//--------------------------------------------------------------------------------------------------
@Override
public WestPlace getPlace(final String token) {
  return new WestPlace(token);
} // getPlace()
//--------------------------------------------------------------------------------------------------
@Override
public String getToken(final WestPlace place) {
  return place.getToken();
} // getToken()
//--------------------------------------------------------------------------------------------------
} // class Tokenizer
//==================================================================================================
public WestPlace(final String token) {
  _token = token;
} // WestPlace()
//--------------------------------------------------------------------------------------------------
public String getToken() {
  return _token;
} // getToken()
//--------------------------------------------------------------------------------------------------
}