package org.greatlogic.customcellexample.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.DataGrid;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.Widget;

public class CustomCellExample implements EntryPoint {

@UiField
DataGrid<Record> dataGrid;

private static class Record {
String _name;
Record(final String name) {
  _name = name;
}
}

interface CustomCellExampleBinder extends UiBinder<Widget, CustomCellExample> { //
}

private void createGridColumns() {
  final Column<Record, String> nameColumn = new Column<Record, String>(new CustomCell(13, 13)) {
    @Override
    public String getValue(final Record record) {
      return record._name;
    }
  };
  dataGrid.addColumn(nameColumn, "Date");
  dataGrid.setColumnWidth(nameColumn, "25ex");
}

@Override
public void onModuleLoad() {
  final CustomCellExampleBinder binder = GWT.create(CustomCellExampleBinder.class);
  final Widget widget = binder.createAndBindUi(this);
  RootLayoutPanel.get().add(widget);
  createGridColumns();
}

}