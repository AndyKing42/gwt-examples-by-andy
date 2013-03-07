package org.greatlogic.datagridinheaderpanel.client;

import com.google.gwt.cell.client.TextInputCell;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.DataGrid;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.Widget;
import java.util.ArrayList;

public class DataGridInHeaderPanel implements EntryPoint {

@UiField
Button                    addRecordButton;
@UiField
DataGrid<Record>          dataGrid;
@UiField
Label                     numberOfRecordsLabel;

private ArrayList<Record> _recordList;

interface DataGridInHeaderPanelBinder extends UiBinder<Widget, DataGridInHeaderPanel> {
}

private static class Record {
private String _field1;
}

@Override
public void onModuleLoad() {
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
  RootLayoutPanel.get().add(widget);
}

@UiHandler("addRecordButton")
public void onAddRecordButtonClick(final ClickEvent event) {
  Record record = new Record();
  record._field1 = "Record " + (_recordList.size() + 1);
  _recordList.add(record);
  dataGrid.setRowData(_recordList);
  numberOfRecordsLabel.setText("Records:" + _recordList.size());
}

}