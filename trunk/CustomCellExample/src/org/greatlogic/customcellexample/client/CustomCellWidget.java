package org.greatlogic.customcellexample.client;

import com.google.gwt.event.dom.client.BlurEvent;
import com.google.gwt.event.dom.client.BlurHandler;
import com.google.gwt.uibinder.client.UiConstructor;
import com.google.gwt.user.cellview.client.CellWidget;

public class CustomCellWidget extends CellWidget<String> {

private BlurHandler createBlurHandler() {
  return new BlurHandler() {
    @Override
    public void onBlur(final BlurEvent event) {
      redraw();
    }
  };
}

@UiConstructor
public CustomCellWidget(final boolean readOnly, final String separator) {
  super(new CustomCell(readOnly, separator));
  addHandler(createBlurHandler(), BlurEvent.getType());
}

}