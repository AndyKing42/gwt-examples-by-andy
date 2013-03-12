package org.greatlogic.placesandactivities.client.activity;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

public abstract class APAbstractActivity extends AbstractActivity {
//--------------------------------------------------------------------------------------------------
public abstract void start(final AcceptsOneWidget panel,
                           com.google.web.bindery.event.shared.EventBus eventBus);
//--------------------------------------------------------------------------------------------------
@Override
public void start(final AcceptsOneWidget panel, final com.google.gwt.event.shared.EventBus eventBus) {
  start(panel, (com.google.web.bindery.event.shared.EventBus)eventBus);
} // start()
//--------------------------------------------------------------------------------------------------
}