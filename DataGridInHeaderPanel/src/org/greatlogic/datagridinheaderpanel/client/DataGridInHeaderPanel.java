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
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ResizeLayoutPanel;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.Widget;

public class DataGridInHeaderPanel implements EntryPoint {

@UiField
Button                    add100RecordsButton;
@UiField
Button                    add10RecordsButton;
@UiField
Button                    addRecordButton;
@UiField(provided = true)
DataGrid<Record>          dataGrid;
@UiField
HeaderPanel               headerPanel;
@UiField
Label                     numberOfRecordsLabel;
@UiField
ResizeLayoutPanel         topLayoutPanel;

private ArrayList<Record> _recordList;

interface DataGridInHeaderPanelBinder extends UiBinder<Widget, DataGridInHeaderPanel> { //
}

private static class Record {
private String _field1;
}

@Override
public void onModuleLoad() {
  dataGrid = new DataGrid<Record>();
  _recordList = new ArrayList<Record>();
  final DataGridInHeaderPanelBinder binder = GWT.create(DataGridInHeaderPanelBinder.class);
  final Widget widget = binder.createAndBindUi(this);
  final Column<Record, String> field1Column = new Column<Record, String>(new TextInputCell()) {
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
    public void onResize(final ResizeEvent event) {
      final int dataGridHeight = headerPanel.getOffsetHeight() -
                                 headerPanel.getHeaderWidget().getOffsetHeight() -
                                 headerPanel.getFooterWidget().getOffsetHeight();
      dataGrid.setHeight((dataGridHeight < 0 ? 0 : dataGridHeight) + "px");
    }
  };
}

@UiHandler("add100RecordsButton")
public void onAdd100RecordsButtonClick(@SuppressWarnings("unused") final ClickEvent event) {
  addRecords(100);
}

@UiHandler("add10RecordsButton")
public void onAdd10RecordsButtonClick(@SuppressWarnings("unused") final ClickEvent event) {
  addRecords(10);
}

@UiHandler("addRecordButton")
public void onAddRecordButtonClick(@SuppressWarnings("unused") final ClickEvent event) {
  addRecords(1);
}

private void addRecords(final int numberOfRecords) {
  for (int recordCount = 0; recordCount < numberOfRecords; ++recordCount) {
    final Record record = new Record();
    record._field1 = "Record " + (_recordList.size() + 1);
    _recordList.add(record);
  }
  dataGrid.setRowData(_recordList);
  dataGrid.setRowCount(_recordList.size(), true);
  numberOfRecordsLabel.setText("Records:" + _recordList.size());
}

}