package org.greatlogic.datagridinheaderpanel.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.Widget;

public class DataGridInHeaderPanel implements EntryPoint {

//@UiField
//HeaderPanel    headerPanel;
//@UiField
//TabLayoutPanel outerPanel;
//@UiField
//ResizeLayoutPanel resizeLayoutPanel;
//@UiField
//SplitLayoutPanel splitLayoutPanel;

interface DataGridInHeaderPanelBinder extends UiBinder<Widget, DataGridInHeaderPanel> { //
}

@Override
public void onModuleLoad() {
  final DataGridInHeaderPanelBinder binder = GWT.create(DataGridInHeaderPanelBinder.class);
  final Widget widget = binder.createAndBindUi(this);
  RootLayoutPanel.get().add(widget);
}

//@UiHandler("resizeLayoutPanel")
//public void onResizeLayoutPanelResize(final ResizeEvent resizeEvent) {
//  final Widget footerWidget = headerPanel.getFooterWidget();
//  final int footerOffsetHeight = footerWidget == null ? 0 : footerWidget.getOffsetHeight();
//  final int dataGridHeight = headerPanel.getOffsetHeight() -
//                             headerPanel.getHeaderWidget().getOffsetHeight() - footerOffsetHeight -
//                             3;
//  resizeLayoutPanel.setHeight((dataGridHeight < 0 ? 0 : dataGridHeight) + "px");
//}

}