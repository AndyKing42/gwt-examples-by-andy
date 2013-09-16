package org.greatlogic.runtimecssexample.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.LinkElement;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Random;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.Widget;

public class RuntimeCSSExample implements EntryPoint {

@UiField
ListBox cssNameListBox;

//==================================================================================================

interface RuntimeCSSExampleBinder extends UiBinder<Widget, RuntimeCSSExample> { //
}

//==================================================================================================

private void applyCSS(final String cssFilename, final String revision) {
  final LinkElement linkElement = Document.get().createLinkElement();
  linkElement.setRel("stylesheet");
  linkElement.setType("text/css");
  linkElement.setHref(GWT.getModuleBaseURL() + "css/" + cssFilename + ".css?" + revision);
  Document.get().getElementsByTagName("head").getItem(0).appendChild(linkElement);
}

@UiHandler("cssNameListBox")
public void onCSSFilenameListBoxChange(@SuppressWarnings("unused") final ChangeEvent event) {
  final String cssFilename = cssNameListBox.getItemText(cssNameListBox.getSelectedIndex());
  final String revision = "" + Random.nextInt();
  applyCSS(cssFilename, revision);
}

@Override
public void onModuleLoad() {
  //  Window.alert("GWT.getModuleBaseURL():" + GWT.getModuleBaseURL()); // http://127.0.0.1:8888/runtimecssexample/
  final RuntimeCSSExampleBinder binder = GWT.create(RuntimeCSSExampleBinder.class);
  final Widget widget = binder.createAndBindUi(this);
  RootLayoutPanel.get().add(widget);
}

}