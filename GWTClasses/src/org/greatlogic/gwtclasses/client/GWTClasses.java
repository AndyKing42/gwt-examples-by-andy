package org.greatlogic.gwtclasses.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.Widget;

public class GWTClasses implements EntryPoint {
//==================================================================================================
interface IGWTClassesBinder extends UiBinder<Widget, GWTClasses> { //
}
//==================================================================================================
@Override
public void onModuleLoad() {
  final IGWTClassesBinder binder = GWT.create(IGWTClassesBinder.class);
  final Widget widget = binder.createAndBindUi(this);
  RootLayoutPanel.get().add(widget);
} // onModuleLoad()
//--------------------------------------------------------------------------------------------------
}