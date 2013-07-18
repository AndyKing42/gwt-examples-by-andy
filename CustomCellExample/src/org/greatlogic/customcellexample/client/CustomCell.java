package org.greatlogic.customcellexample.client;

import org.greatlogic.customcellexample.client.CustomCell.GLDateCellViewData;
import com.google.gwt.cell.client.AbstractInputCell;
import com.google.gwt.cell.client.TextInputCell.ViewData;
import com.google.gwt.cell.client.ValueUpdater;
import com.google.gwt.dom.client.BrowserEvents;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.InputElement;
import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;

public class CustomCell extends AbstractInputCell<String, GLDateCellViewData> {
//--------------------------------------------------------------------------------------------------
private final int _add2000BelowYY;
private final int _add1900AboveYY;
//==================================================================================================
public static class GLDateCellViewData extends ViewData {
public GLDateCellViewData(final String value) {
  super(value);
} // GLDateCellViewData()
@Override
protected void setCurrentValue(final String value) {
  super.setCurrentValue(value);
} // setCurrentValue()
@Override
protected void setLastValue(final String value) {
  super.setLastValue(value);
} // setLastValue()
} // class GLDateCellViewData
//==================================================================================================
public CustomCell(final int add2000BelowYY, final int add1900AboveYY) {
  super(BrowserEvents.BLUR, BrowserEvents.CHANGE, BrowserEvents.FOCUS);
  _add2000BelowYY = add2000BelowYY;
  _add1900AboveYY = add1900AboveYY;
} // CustomCell()
//--------------------------------------------------------------------------------------------------
@Override
protected void finishEditing(final Element parent, final String value, final Object key,
                             final ValueUpdater<String> valueUpdater) {
  String newValue = getInputElement(parent).getValue();
  final String[] dateParts = newValue.split("/");
  if (dateParts.length != 3) {
    return;
  }
  final int month = Integer.valueOf(dateParts[0]);
  final int day = Integer.valueOf(dateParts[1]);
  int year = Integer.valueOf(dateParts[2]);
  if (year <= _add2000BelowYY) {
    year += 2000;
  }
  else if (year >= 0 && year <= 100 && year >= _add1900AboveYY) {
    year += 1900;
  }
  newValue = year + (month < 10 ? "0" : "") + month + (day < 10 ? "0" : "") + day;
  parent.setInnerSafeHtml(getSafeHtml(newValue));
  GLDateCellViewData vd = getViewData(key);
  if (vd == null) {
    vd = new GLDateCellViewData(value);
    setViewData(key, vd);
  }
  vd.setCurrentValue(newValue);
  if (valueUpdater != null && !vd.getCurrentValue().equals(vd.getLastValue())) {
    vd.setLastValue(newValue);
    valueUpdater.update(newValue);
  }
  super.finishEditing(parent, newValue, key, valueUpdater);
} // finishEditing()
//--------------------------------------------------------------------------------------------------
@Override
protected InputElement getInputElement(final Element parent) {
  return super.getInputElement(parent).<InputElement> cast();
} // getInputElement()
//--------------------------------------------------------------------------------------------------
private SafeHtml getSafeHtml(final String yyyymmdd) {
  String html = "<input type='text' tabindex='-1'";
  if (yyyymmdd != null && !yyyymmdd.isEmpty()) {
    html += " value='" + yyyymmdd.substring(4, 6) + "/" + yyyymmdd.substring(6, 8) + "/" +
            yyyymmdd.substring(0, 4) + "'";
  }
  html += "/>";
  return SafeHtmlUtils.fromTrustedString(html);
} // getSafeHtml()
//--------------------------------------------------------------------------------------------------
@Override
public void onBrowserEvent(final Context context, final Element parent, final String value,
                           final NativeEvent event, final ValueUpdater<String> valueUpdater) {
  super.onBrowserEvent(context, parent, value, event, valueUpdater);
  final InputElement inputElement = getInputElement(parent);
  final Element target = event.getEventTarget().cast();
  if (!inputElement.isOrHasChild(target)) {
    return;
  }
  final String eventType = event.getType();
  final Object key = context.getKey();
  if (eventType.equals(BrowserEvents.CHANGE)) {
    finishEditing(parent, value, key, valueUpdater);
  }
  else if (eventType.equals(BrowserEvents.KEYUP)) {
    GLDateCellViewData vd = getViewData(key);
    if (vd == null) {
      vd = new GLDateCellViewData(value);
      setViewData(key, vd);
    }
    vd.setCurrentValue(inputElement.getValue());
  }
} // onBrowserEvents()
//--------------------------------------------------------------------------------------------------
@Override
public void render(final Context context, final String value, final SafeHtmlBuilder sb) {
  if (value == null) {
    return;
  }
  final Object key = context.getKey();
  GLDateCellViewData vd = getViewData(key);
  if (vd != null && vd.getCurrentValue().equals(value)) {
    clearViewData(key);
    vd = null;
  }
  final String currentValue = vd == null ? value : vd.getCurrentValue();
  sb.append(getSafeHtml(currentValue));
} // render()
//--------------------------------------------------------------------------------------------------
}