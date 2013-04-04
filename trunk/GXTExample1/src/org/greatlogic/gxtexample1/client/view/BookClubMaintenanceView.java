package org.greatlogic.gxtexample1.client.view;

import org.greatlogic.gxtexample1.client.IClientFactory;
import org.greatlogic.gxtexample1.client.event.BookClubListPositionChangedEvent;
import org.greatlogic.gxtexample1.client.event.BookClubListPositionChangedEvent.IBookClubListPositionChangedEventHandler;
import org.greatlogic.gxtexample1.client.event.BookClubNameChangeEvent;
import org.greatlogic.gxtexample1.client.event.BookClubNameChangeEvent.IBookClubNameChangeEventHandler;
import org.greatlogic.gxtexample1.client.event.BookClubSelectedEvent;
import org.greatlogic.gxtexample1.client.event.BookClubSelectedEvent.IBookClubSelectedEventHandler;
import org.greatlogic.gxtexample1.client.event.BookClubsLoadedEvent;
import org.greatlogic.gxtexample1.client.event.BookClubsLoadedEvent.IBookClubsLoadedEventHandler;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiFactory;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.core.client.Style.LayoutRegion;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.BorderLayoutContainer;
import com.sencha.gxt.widget.core.client.container.Viewport;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.event.SelectEvent.SelectHandler;

public class BookClubMaintenanceView extends Composite implements
                                                      IBookClubListPositionChangedEventHandler,
                                                      IBookClubNameChangeEventHandler,
                                                      IBookClubSelectedEventHandler,
                                                      IBookClubsLoadedEventHandler {
//--------------------------------------------------------------------------------------------------
//@UiField
//ListBox                   bookClubListBox;
//@UiField(provided = true)
//BookClubMaintenanceWidget bookClubMaintenanceWidget;
@UiField
Viewport               viewport;

private IClientFactory _clientFactory;
//==================================================================================================
public interface IBookClubMaintenanceViewUiBinder extends UiBinder<Widget, BookClubMaintenanceView> { //
} // interface IBookClubMaintenanceViewUiBinder
//==================================================================================================
public Viewport getViewport() {
  return viewport;
} // getViewport()
//--------------------------------------------------------------------------------------------------
public void initialize(final IClientFactory clientFactory) {
  _clientFactory = clientFactory;
  //  bookClubMaintenanceWidget = new BookClubMaintenanceWidget(_clientFactory);
  final IBookClubMaintenanceViewUiBinder binder = GWT.create(IBookClubMaintenanceViewUiBinder.class);
  binder.createAndBindUi(this);
  //  bookClubMaintenanceContainer.setWidget(bookClubListBox);
  _clientFactory.getRequestFactory().getEventBus().addHandler(BookClubListPositionChangedEvent.BookClubListPositionChangedEventType,
                                                              this);
  _clientFactory.getRequestFactory().getEventBus().addHandler(BookClubNameChangeEvent.BookClubNameChangeEventType,
                                                              this);
  _clientFactory.getRequestFactory().getEventBus().addHandler(BookClubSelectedEvent.BookClubSelectedEventType,
                                                              this);
  _clientFactory.getRequestFactory().getEventBus().addHandler(BookClubsLoadedEvent.BookClubsLoadedEventType,
                                                              this);
  _clientFactory.getBookClubCache().loadAllBookClubs();
} // initialize()
//--------------------------------------------------------------------------------------------------
//@SuppressWarnings("unused")
//@UiHandler("newButton")
//public void onNewButtonSelect(final SelectEvent event) {
//  requestConfirmationToSaveCurrentChanges();
//  bookClubMaintenanceWidget.editBookClub(null);
//  //  _handlerRegistration.removeHandler();
//} // onNewButtonSelect()
//--------------------------------------------------------------------------------------------------
@Override
public void onBookClubListPositionChangedEvent(final BookClubListPositionChangedEvent bookClubListPositionChangedEvent) {
  //  final IBookClubProxy bookClub = bookClubListPositionChangedEvent.getBookClub();
  //  if (bookClubListPositionChangedEvent.getRemoveIndex() >= 0) {
  //    bookClubListBox.removeItem(bookClubListPositionChangedEvent.getRemoveIndex());
  //  }
  //  if (bookClubListPositionChangedEvent.getInsertIndex() >= 0) {
  //    bookClubListBox.insertItem(bookClub.getName(), Integer.toString(bookClub.getId()),
  //                               bookClubListPositionChangedEvent.getInsertIndex());
  //  }
} // onBookClubListPositionChangedEvent()
//--------------------------------------------------------------------------------------------------
//@SuppressWarnings("unused")
//@UiHandler("bookClubListBox")
//public void onBookClubListBoxChange(final ChangeEvent event) {
//  final int selectedIndex = bookClubListBox.getSelectedIndex();
//  if (selectedIndex >= 0) {
//    final int bookClubId = Integer.parseInt(bookClubListBox.getValue(selectedIndex));
//    _clientFactory.getEventBus().fireEvent(new BookClubSelectedEvent(bookClubId));
//  }
//} // onBookClubListBoxChange()
//--------------------------------------------------------------------------------------------------
@Override
public void onBookClubNameChangeEvent(final BookClubNameChangeEvent bookClubNameChangeEvent) {
  //  for (int listBoxIndex = 0; listBoxIndex < bookClubListBox.getItemCount(); ++listBoxIndex) {
  //    if (Integer.valueOf(bookClubListBox.getValue(listBoxIndex)) == bookClubNameChangeEvent.getBookClub().getId()) {
  //      bookClubListBox.setItemText(listBoxIndex, bookClubNameChangeEvent.getNewName());
  //      break;
  //    }
  //  }
} // onBookClubNameChangeEvent()
//--------------------------------------------------------------------------------------------------
/**
 * Loads the selected BookClub into the editor.
 */
@Override
public void onBookClubSelectedEvent(final BookClubSelectedEvent bookClubSelectedEvent) {
  //  requestConfirmationToSaveCurrentChanges();
  //  final IBookClubProxy bookClub = _clientFactory.getBookClubCache().getBookClub(bookClubSelectedEvent.getBookClubId());
  //  bookClubMaintenanceWidget.editBookClub(bookClub);
} // onBookClubSelectedEvent()
//--------------------------------------------------------------------------------------------------
@Override
public void onBookClubsLoadedEvent(final BookClubsLoadedEvent bookClubsLoadedEvent) {
  //  bookClubListBox.clear();
  //  for (final IBookClubProxy bookClub : _clientFactory.getBookClubCache().getBookClubList()) {
  //    bookClubListBox.addItem(bookClub.getName(), Integer.toString(bookClub.getId()));
  //  }
} // onBookClubsLoadedEvent()
//--------------------------------------------------------------------------------------------------
//@SuppressWarnings("unused")
//@UiHandler("saveButton")
//public void onSaveButtonSelect(final SelectEvent selectEvent) {
//  if (bookClubMaintenanceWidget.getBookClub() != null) {
//    bookClubMaintenanceWidget.saveCurrentChanges();
//  }
//} // onSaveButtonSelect()
//--------------------------------------------------------------------------------------------------
//@SuppressWarnings("unused")
//@UiHandler("undoButton")
//public void onUndoButtonSelect(final SelectEvent selectEvent) {
//  bookClubMaintenanceWidget.undoCurrentChanges();
//} // onUndoButtonSelect()
//--------------------------------------------------------------------------------------------------
//private void requestConfirmationToSaveCurrentChanges() {
//  if (bookClubMaintenanceWidget.isChanged()) {
//    if (Window.confirm("Do you want to save the current changes?")) {
//      bookClubMaintenanceWidget.saveCurrentChanges();
//    }
//    else {
//      bookClubMaintenanceWidget.undoCurrentChanges();
//    }
//  }
//} // requestConfirmationToSaveCurrentChanges()
//--------------------------------------------------------------------------------------------------
}