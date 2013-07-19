package org.greatlogic.customcellexample.client;

import org.greatlogic.customcellexample.client.CustomCell.CustomCellViewData;
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

public class CustomCell extends AbstractInputCell<String, CustomCellViewData> {

private final String _separator;

//==================================================================================================

public static class CustomCellViewData extends ViewData {
public CustomCellViewData(final String value) {
  super(value);
}

@Override
protected void setCurrentValue(final String value) {
  super.setCurrentValue(value);
}

@Override
protected void setLastValue(final String value) {
  super.setLastValue(value);
}

} // class CustomCellViewData

//==================================================================================================

public CustomCell(final String separator) {
  super(BrowserEvents.BLUR, BrowserEvents.CHANGE, BrowserEvents.FOCUS);
  _separator = separator;
}

@Override
protected void finishEditing(final Element parent, final String value, final Object key,
                             final ValueUpdater<String> valueUpdater) {
  final String newValue = getInputElement(parent).getValue();
  parent.setInnerSafeHtml(getSafeHtml(newValue));
  CustomCellViewData viewData = getViewData(key);
  if (viewData == null) {
    viewData = new CustomCellViewData(value);
    setViewData(key, viewData);
  }
  viewData.setCurrentValue(newValue);
  if (valueUpdater != null && !viewData.getCurrentValue().equals(viewData.getLastValue())) {
    viewData.setLastValue(newValue);
    valueUpdater.update(newValue);
  }
  super.finishEditing(parent, newValue, key, valueUpdater);
}

@Override
protected InputElement getInputElement(final Element parent) {
  return super.getInputElement(parent).<InputElement> cast();
}

private SafeHtml getSafeHtml(final String phoneNumber) {
  String html = "<input type='text' tabindex='-1'";
  if (phoneNumber != null && !phoneNumber.isEmpty()) {
    html += " value='" + phoneNumber + "'";
  }
  html += "/>";
  return SafeHtmlUtils.fromTrustedString(html);
}

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
    CustomCellViewData viewData = getViewData(key);
    if (viewData == null) {
      viewData = new CustomCellViewData(value);
      setViewData(key, viewData);
    }
    viewData.setCurrentValue(inputElement.getValue());
  }
}

@Override
public void render(final Context context, final String value, final SafeHtmlBuilder sb) {
  if (value == null) {
    return;
  }
  final Object key = context.getKey();
  CustomCellViewData viewData = getViewData(key);
  if (viewData != null && viewData.getCurrentValue().equals(value)) {
    clearViewData(key);
    viewData = null;
  }
  final String currentValue = viewData == null ? value : viewData.getCurrentValue();
  sb.append(getSafeHtml(currentValue));
}

}