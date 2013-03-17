package org.greatlogic.datagridinheaderpanel.client;

import java.util.ArrayList;
import com.google.gwt.cell.client.TextInputCell;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.logical.shared.ResizeEvent;
import com.google.gwt.event.logical.shared.ResizeHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.DataGrid;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HeaderPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ResizeLayoutPanel;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.Widget;

public class DataGridInHeaderPanel implements EntryPoint {

@UiField
Button                    addRecordButton;
@UiField
HorizontalPanel           addRecordPanel;
@UiField(provided = true)
DataGrid<Record>          dataGrid;
@UiField
HeaderPanel               headerPanel;
@UiField
Label                     numberOfRecordsLabel;
@UiField
ResizeLayoutPanel         topLayoutPanel;

private ArrayList<Record> _recordList;

interface DataGridInHeaderPanelBinder extends UiBinder<Widget, DataGridInHeaderPanel> {
}

private static class Record {
private String _field1;
}

@Override
public void onModuleLoad() {
  dataGrid = new DataGrid<Record>();
  _recordList = new ArrayList<Record>();
  DataGridInHeaderPanelBinder binder = GWT.create(DataGridInHeaderPanelBinder.class);
  Widget widget = binder.createAndBindUi(this);
  Column<Record, String> field1Column = new Column<Record, String>(new TextInputCell()) {
    @Override
    public String getValue(final Record record) {
      return record._field1;
    }
  };
  dataGrid.addColumn(field1Column, "Field 1");
  topLayoutPanel.addHandler(createLayoutPanelResizeHandler(), ResizeEvent.getType());
  RootLayoutPanel.get().add(widget);
}

private ResizeHandler createLayoutPanelResizeHandler() {
  return new ResizeHandler() {
    @Override
    public void onResize(ResizeEvent event) {
      int dataGridHeight = headerPanel.getOffsetHeight() -
                           headerPanel.getHeaderWidget().getOffsetHeight() -
                           headerPanel.getFooterWidget().getOffsetHeight() - 30;
      dataGrid.setHeight((dataGridHeight < 0 ? 0 : dataGridHeight) + "px");
    }
  };
}

@UiHandler("addRecordButton")
public void onAddRecordButtonClick(final ClickEvent event) {
  Record record = new Record();
  record._field1 = "Record " + (_recordList.size() + 1);
  _recordList.add(record);
  dataGrid.setRowData(_recordList);
  dataGrid.setRowCount(_recordList.size(), true);
  numberOfRecordsLabel.setText("Records:" + _recordList.size());
}

}