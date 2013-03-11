package org.greatlogic.elementalfile.client;

import static elemental.client.Browser.getDocument;
import static elemental.client.Browser.getWindow;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.user.client.Window;
import elemental.dom.Element;
import elemental.dom.Node;
import elemental.dom.NodeList;
import elemental.dom.TimeoutHandler;
import elemental.events.Event;
import elemental.events.EventListener;
import elemental.html.ButtonElement;
import elemental.html.DivElement;
import elemental.html.InputElement;
import elemental.xml.XMLHttpRequest;

public class ElementalFileEntryPoint implements EntryPoint {

@Override
public void onModuleLoad() {
  Element element = getDocument().getElementById("files");
  NodeList nodeList = getDocument().getChildNodes();
  for (int nodeIndex = 0; nodeIndex < nodeList.getLength(); ++nodeIndex) {
    Node node = nodeList.item(nodeIndex);
    if (node == null) {
      node = null;
    }
  }
  //  createNativeEventHandler();
  //  final ButtonElement btn = getDocument().createButtonElement();
  //  btn.setInnerHTML("w00t?");
  //  btn.getStyle().setColor("red");
  //  getDocument().getBody().appendChild(btn);

  //  <input type="file" id="files" name="files[]" multiple />
  //  <output id="list"></output>
  //
  //    <script>
  //      function handleFileSelect(evt) {
  //        var files = evt.target.files; // FileList object
  //  
  //        // files is a FileList of File objects. List some properties.
  //        var output = [];
  //        for (var i = 0, f; f = files[i]; i++) {
  //          output.push('<li><strong>', escape(f.name), '</strong> (', f.type || 'n/a', ') - ',
  //                      f.size, ' bytes, last modified: ',
  //                      f.lastModifiedDate.toLocaleDateString(), '</li>');
  //        }
  //        document.getElementById('list').innerHTML = '<ul>' + output.join('') + '</ul>';
  //      }
  //  
  //      document.getElementById('files').addEventListener('change', handleFileSelect, false);
  //    </script>

  //  InputElement inputElement = getDocument().createInputElement();
  //  inputElement.setId("fileInput");
  //  inputElement.setType("file");
  //  inputElement.setMultiple(false);
  //  inputElement.setTitle("Select files to be processed");
  //  inputElement.setOnchange(createFileInputOnchangeListener());
  //  //  inputElement.addEventListener("change", createFileInputOnchangeListener(), false);
  //  getDocument().getBody().appendChild(inputElement);

  //  final DivElement div = getDocument().createDivElement();
  //  getDocument().getBody().appendChild(div);

  //  EventListener listener = new EventListener() {
  //    @Override
  //    public void handleEvent(Event evt) {
  //      final XMLHttpRequest xhr = getWindow().newXMLHttpRequest();
  //      xhr.setOnload(new EventListener() {
  //        @Override
  //        public void handleEvent(Event evt2) {
  //          div.setInnerHTML(xhr.getResponseText());
  //        }
  //      });
  //      xhr.open("GET", "/snippet.html");
  //      xhr.send();
  //
  //      getWindow().setTimeout(new TimeoutHandler() { // *** changed from "new Window.TimerCallback()"
  //        @Override
  //        public void onTimeoutHandler() { // *** changed from "public void fire()"
  //          getWindow().alert("timeout fired");
  //        }
  //      }, 1000);
  //
  //      btn.removeEventListener(Event.CLICK, this, false);
  //    }
  //  };
  //  btn.addEventListener(Event.CLICK, listener, false);
}

private EventListener createFileInputOnchangeListener() {
  EventListener result = new EventListener() {
    @Override
    public void handleEvent(final Event event) {
      Window.alert("change");
    }
  };
  return result;
}

public native void createNativeEventHandler() /*-{
	function handleFileSelect(evt) {
		var files = evt.target.files; // FileList object
		// files is a FileList of File objects. List some properties.
		var output = [];
		for ( var i = 0, f; f = files[i]; i++) {
			output.push('<li><strong>', escape(f.name), '</strong> (', f.type
					|| 'n/a', ') - ', f.size, ' bytes, last modified: ',
					f.lastModifiedDate.toLocaleDateString(), '</li>');
		}
		document.getElementById('list').innerHTML = '<ul>' + output.join('')
				+ '</ul>';
	}
	document.getElementById('files').addEventListener('change',
			handleFileSelect, false);
}-*/;

}