package org.greatlogic.runtimecssexample.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.LinkElement;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.Widget;

public class RuntimeCSSExample implements EntryPoint {

//==================================================================================================

interface RuntimeCSSExampleBinder extends UiBinder<Widget, RuntimeCSSExample> { //
}

//==================================================================================================

private void applyCSS(final String cssFilename, final String version) {
  final LinkElement linkElement = Document.get().createLinkElement();
  linkElement.setRel("stylesheet");
  linkElement.setType("text/css");
  linkElement.setHref(GWT.getModuleBaseURL() + "css/" + cssFilename + ".css?" + version);
  Document.get().getElementsByTagName("head").getItem(0).appendChild(linkElement);
}

@Override
public void onModuleLoad() {
  Window.alert("GWT.getModuleBaseURL():" + GWT.getModuleBaseURL()); // http://127.0.0.1:8888/runtimecssexample/
  final RuntimeCSSExampleBinder binder = GWT.create(RuntimeCSSExampleBinder.class);
  final Widget widget = binder.createAndBindUi(this);
  RootLayoutPanel.get().add(widget);
}

}