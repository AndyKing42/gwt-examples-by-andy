package org.greatlogic.customcellexample.client;

import java.util.ArrayList;
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
DataGrid<PhoneRecord>          dataGrid;

private ArrayList<PhoneRecord> _phoneRecordList;

//==================================================================================================

private static class PhoneRecord {

private final String _phoneNumber;

PhoneRecord(final String phoneNumber) {
  _phoneNumber = phoneNumber;
}

} // class PhoneRecord

//==================================================================================================

interface CustomCellExampleBinder extends UiBinder<Widget, CustomCellExample> { //
}

//==================================================================================================

private void createGridColumns() {
  final Column<PhoneRecord, String> nameColumn;
  nameColumn = new Column<PhoneRecord, String>(new CustomCell("-")) {
    @Override
    public String getValue(final PhoneRecord record) {
      return record._phoneNumber;
    }
  };
  dataGrid.addColumn(nameColumn, "Date");
  dataGrid.setColumnWidth(nameColumn, "25ex");
}

public void createSampleData() {
  _phoneRecordList = new ArrayList<PhoneRecord>();
  for (int recordCount = 0; recordCount < 100; ++recordCount) {
    _phoneRecordList.add(new PhoneRecord("1234567890"));
  }
  dataGrid.setRowData(_phoneRecordList);
  dataGrid.setRowCount(_phoneRecordList.size(), true);
}

@Override
public void onModuleLoad() {
  final CustomCellExampleBinder binder = GWT.create(CustomCellExampleBinder.class);
  final Widget widget = binder.createAndBindUi(this);
  RootLayoutPanel.get().add(widget);
  createGridColumns();
  createSampleData();
}

}