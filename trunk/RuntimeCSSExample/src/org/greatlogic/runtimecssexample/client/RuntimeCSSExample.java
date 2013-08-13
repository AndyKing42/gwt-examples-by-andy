package org.greatlogic.runtimecssexample.client;

import java.util.ArrayList;
import com.google.gwt.cell.client.FieldUpdater;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.LinkElement;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.DataGrid;
import com.google.gwt.user.client.Random;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.ListDataProvider;

public class RuntimeCSSExample implements EntryPoint {

@UiField
ListBox                               cssListBox;
@UiField
DataGrid<PhoneRecord>                 dataGrid1;
@UiField
DataGrid<PhoneRecord>                 dataGrid2;

private ListDataProvider<PhoneRecord> _phoneRecordDataProvider;

//==================================================================================================

private static class PhoneRecord {

private String _phoneNumber;

PhoneRecord(final String phoneNumber) {
  _phoneNumber = phoneNumber;
}

} // class PhoneRecord

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

private void createGridColumns() {
  final Column<PhoneRecord, String> phoneNumberColumn;
  phoneNumberColumn = new Column<PhoneRecord, String>(new CustomCell(false, "-")) {
    @Override
    public String getValue(final PhoneRecord record) {
      return record._phoneNumber;
    }
  };
  phoneNumberColumn.setFieldUpdater(new FieldUpdater<PhoneRecord, String>() {
    @Override
    public void update(final int index, final PhoneRecord phoneRecord, final String value) {
      phoneRecord._phoneNumber = value;
      _phoneRecordDataProvider.refresh();
    }
  });
  dataGrid1.addColumn(phoneNumberColumn, "Editable Phone Number");
  dataGrid1.setColumnWidth(phoneNumberColumn, "25ex");
  final Column<PhoneRecord, String> phoneNumberColumn2;
  phoneNumberColumn2 = new Column<PhoneRecord, String>(new CustomCell(true, "-")) {
    @Override
    public String getValue(final PhoneRecord record) {
      return record._phoneNumber;
    }
  };
  dataGrid2.addColumn(phoneNumberColumn2, "Read-only Phone Number");
  dataGrid2.setColumnWidth(phoneNumberColumn2, "25ex");
}

public ArrayList<PhoneRecord> createSampleData() {
  final ArrayList<PhoneRecord> result = new ArrayList<PhoneRecord>();
  for (int recordCount = 0; recordCount < 100; ++recordCount) {
    String phoneNumber;
    do {
      phoneNumber = "" + (Random.nextInt(800000000) + 200000000) + Random.nextInt(10);
    } while (phoneNumber.charAt(1) == '9' || phoneNumber.charAt(3) == '0' ||
             phoneNumber.charAt(3) == '1' ||
             (phoneNumber.charAt(4) == '1' && phoneNumber.charAt(5) == '1'));
    result.add(new PhoneRecord(phoneNumber));
  }
  return result;
}

@UiHandler("cssListBox")
public void onCSSListBoxChange(@SuppressWarnings("unused") final ChangeEvent event) {
  applyCSS(cssListBox.getItemText(cssListBox.getSelectedIndex()), "" + System.currentTimeMillis());
}

@Override
public void onModuleLoad() {
  Window.alert("GWT.getModuleBaseURL():" + GWT.getModuleBaseURL()); // http://127.0.0.1:8888/runtimecssexample/
  final RuntimeCSSExampleBinder binder = GWT.create(RuntimeCSSExampleBinder.class);
  final Widget widget = binder.createAndBindUi(this);
  RootLayoutPanel.get().add(widget);
  createGridColumns();
  _phoneRecordDataProvider = new ListDataProvider<RuntimeCSSExample.PhoneRecord>(createSampleData());
  _phoneRecordDataProvider.addDataDisplay(dataGrid1);
  _phoneRecordDataProvider.addDataDisplay(dataGrid2);
}

}