package org.greatlogic.datagridinheaderpanel.client;

import com.google.gwt.cell.client.EditTextCell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.DataGrid;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ResizeComposite;
import com.google.gwt.user.client.ui.Widget;
import java.util.ArrayList;

public class DataGridWidget extends ResizeComposite {

@UiField
DataGrid<Record>                dataGrid;
@UiField
Label                           numberOfRecordsLabel;

private final ArrayList<Record> _recordList;

interface IDataGridWidgetBinder extends UiBinder<Widget, DataGridWidget> { //
}

public DataGridWidget() {
  _recordList = new ArrayList<Record>();
  final IDataGridWidgetBinder binder = GWT.create(IDataGridWidgetBinder.class);
  initWidget(binder.createAndBindUi(this));
  createGridColumns();
} // DataGridWidget()

private static class Record {
String _name;
Record(final String name) {
  _name = name;
}
}

private void createGridColumns() {
  final Column<Record, String> nameColumn = new Column<Record, String>(new EditTextCell()) {
    @Override
    public String getValue(final Record record) {
      return record._name;
    }
  };
  dataGrid.addColumn(nameColumn, "Name");
  dataGrid.setColumnWidth(nameColumn, "25ex");
}

@UiHandler("add100RecordsButton")
public void onAdd100RecordsButtonClick(@SuppressWarnings("unused") final ClickEvent event) {
  for (int recordCount = 0; recordCount < 100; ++recordCount) {
    _recordList.add(new Record("Record " + (_recordList.size() + 1)));
  }
  dataGrid.setRowData(_recordList);
  dataGrid.setRowCount(_recordList.size(), true);
  numberOfRecordsLabel.setText("Records:" + _recordList.size());
}

}