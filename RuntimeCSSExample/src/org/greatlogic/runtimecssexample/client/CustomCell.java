package org.greatlogic.runtimecssexample.client;

import org.greatlogic.runtimecssexample.client.CustomCell.CustomCellViewData;
import com.google.gwt.cell.client.AbstractInputCell;
import com.google.gwt.cell.client.TextInputCell.ViewData;
import com.google.gwt.cell.client.ValueUpdater;
import com.google.gwt.dom.client.BrowserEvents;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.InputElement;
import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;

public class CustomCell extends AbstractInputCell<String, CustomCellViewData> {

private final boolean _readOnly;
private final String  _separator;

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

public CustomCell(final boolean readOnly, final String separator) {
  super(BrowserEvents.CHANGE);
  _readOnly = readOnly;
  _separator = separator;
}

@Override
protected void finishEditing(final Element parent, final String value, final Object key,
                             final ValueUpdater<String> valueUpdater) {
  CustomCellViewData viewData = getViewData(key);
  final String newValue = unformatValue(getInputElement(parent).getValue());
  final boolean valueChanged = viewData == null || !newValue.equals(viewData.getLastValue());
  if (valueChanged) {
    if (viewData == null) {
      viewData = new CustomCellViewData("");
      setViewData(key, viewData);
    }
    viewData.setCurrentValue(newValue);
    viewData.setLastValue(newValue);
    if (valueUpdater != null) {
      valueUpdater.update(newValue);
    }
  }
  super.finishEditing(parent, newValue, key, valueUpdater);
}

/**
 * Formats a value into the display format.
 * @param value The raw (unformatted) value.
 * @return The formatted value, which will be displayed to the user.
 */
protected String formatValue(final String value) {
  if (value.length() != 10) {
    return value;
  }
  return value.substring(0, 3) + _separator + value.substring(3, 6) + _separator +
         value.substring(6);
}

@Override
protected InputElement getInputElement(final Element parent) {
  return super.getInputElement(parent).<InputElement> cast();
}

@Override
public void onBrowserEvent(final Context context, final Element parent, final String value,
                           final NativeEvent event, final ValueUpdater<String> valueUpdater) {
  super.onBrowserEvent(context, parent, value, event, valueUpdater);
  final String eventType = event.getType();
  if (eventType.equals(BrowserEvents.CHANGE)) {
    final InputElement inputElement = getInputElement(parent);
    final Element target = event.getEventTarget().cast();
    if (!inputElement.isOrHasChild(target)) {
      return;
    }
    final Object key = context.getKey();
    finishEditing(parent, value, key, valueUpdater);
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
  sb.append(SafeHtmlUtils.fromTrustedString("<input type='text' tabindex='-1' value='" +
                                            formatValue(currentValue) + "'" +
                                            (_readOnly ? " readonly='true'" : "") + "/>"));
}

/**
 * Removes formatting from a value that was entered by the user.
 * @param value The value that was received from the user.
 * @return The value without formatting.
 */
protected String unformatValue(final String value) {
  String result = value.length() > 1 && value.charAt(0) == '1' ? value.substring(1) : value;
  result = result.length() > 1 && result.charAt(0) == '-' ? result.substring(1) : result;
  return result.length() == 12 ? result.replaceAll(_separator, "") : result;
}

}