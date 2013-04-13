package org.greatlogic.gwtclasses.server;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Enumeration;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.greatlogic.gwtclasses.server.IServerEnums.EConfigAD;
import com.google.common.collect.Maps;
import com.greatlogic.glbase.gllib.GLConfig;
import com.greatlogic.glbase.gllib.GLLog;
/**
 * This singleton class loads the classes from the GWT Javadoc HTML files. The lines of interest are
 * like this:
 * <div class="subTitle">com.google.gwt.user.client.ui</div>
 * <h2 title="Class SplitLayoutPanel" class="title">Class SplitLayoutPanel</h2>
 * </div>
 * <div class="contentContainer">
 * <ul class="inheritance">
 * <li>java.lang.Object</li>
 * <li>
 * <ul class="inheritance">
 * <li>java.lang.Object</li>
 * <li>
 * <ul class="inheritance">
 * <li><a href="../../../../../../com/google/gwt/user/client/ui/UIObject.html" title="class in com.google.gwt.user.client.ui">com.google.gwt.user.client.ui.UIObject</a></li>
 * <li>
 * <ul class="inheritance">
 * <li><a href="../../../../../../com/google/gwt/user/client/ui/Widget.html" title="class in com.google.gwt.user.client.ui">com.google.gwt.user.client.ui.Widget</a></li>
 * <li>
 * <ul class="inheritance">
 * <li><a href="../../../../../../com/google/gwt/user/client/ui/Panel.html" title="class in com.google.gwt.user.client.ui">com.google.gwt.user.client.ui.Panel</a></li>
 * <li>
 * <ul class="inheritance">
 * <li><a href="../../../../../../com/google/gwt/user/client/ui/ComplexPanel.html" title="class in com.google.gwt.user.client.ui">com.google.gwt.user.client.ui.ComplexPanel</a></li>
 * <li>
 * <ul class="inheritance">
 * <li><a href="../../../../../../com/google/gwt/user/client/ui/DockLayoutPanel.html" title="class in com.google.gwt.user.client.ui">com.google.gwt.user.client.ui.DockLayoutPanel</a></li>
 * <li>
 * <ul class="inheritance">
 * <li>com.google.gwt.user.client.ui.SplitLayoutPanel</li>
 * </ul>
 * </li>
 * </ul>
 * </li>
 * </ul>
 * </li>
 * </ul>
 * </li>
 * </ul>
 * </li>
 * </ul>
 * </li>
 * </ul>
 * <div class="description">
 * <ul class="blockList">
 * <li class="blockList">
 * <dl>
 * <dt>All Implemented Interfaces:</dt>
 * <dd><a href="../../../../../../com/google/gwt/event/logical/shared/HasAttachHandlers.html" title="interface in com.google.gwt.event.logical.shared">HasAttachHandlers</a>, <a href="../../../../../../com/google/gwt/event/shared/HasHandlers.html" title="interface in com.google.gwt.event.shared">HasHandlers</a>, <a href="../../../../../../com/google/gwt/user/client/EventListener.html" title="interface in com.google.gwt.user.client">EventListener</a>, <a href="../../../../../../com/google/gwt/user/client/ui/AnimatedLayout.html" title="interface in com.google.gwt.user.client.ui">AnimatedLayout</a>, <a href="../../../../../../com/google/gwt/user/client/ui/HasVisibility.html" title="interface in com.google.gwt.user.client.ui">HasVisibility</a>, <a href="../../../../../../com/google/gwt/user/client/ui/HasWidgets.html" title="interface in com.google.gwt.user.client.ui">HasWidgets</a>, <a href="../../../../../../com/google/gwt/user/client/ui/HasWidgets.ForIsWidget.html" title="interface in com.google.gwt.user.client.ui">HasWidgets.ForIsWidget</a>, <a href="../../../../../../com/google/gwt/user/client/ui/IndexedPanel.html" title="interface in com.google.gwt.user.client.ui">IndexedPanel</a>, <a href="../../../../../../com/google/gwt/user/client/ui/IndexedPanel.ForIsWidget.html" title="interface in com.google.gwt.user.client.ui">IndexedPanel.ForIsWidget</a>, <a href="../../../../../../com/google/gwt/user/client/ui/IsWidget.html" title="interface in com.google.gwt.user.client.ui">IsWidget</a>, <a href="../../../../../../com/google/gwt/user/client/ui/ProvidesResize.html" title="interface in com.google.gwt.user.client.ui">ProvidesResize</a>, <a href="../../../../../../com/google/gwt/user/client/ui/RequiresResize.html" title="interface in com.google.gwt.user.client.ui">RequiresResize</a>, java.lang.Iterable&lt;<a href="../../../../../../com/google/gwt/user/client/ui/Widget.html" title="class in com.google.gwt.user.client.ui">Widget</a>&gt;</dd>
 * </dl>
 * <hr>
 * <br>
 * <pre>public class <span class="strong">SplitLayoutPanel</span>
 * extends <a href="../../../../../../com/google/gwt/user/client/ui/DockLayoutPanel.html" title="class in com.google.gwt.user.client.ui">DockLayoutPanel</a></pre>
 * <div class="block">A panel that adds user-positioned splitters between each of its child
 *  widgets.
 * 
 *  <p>
 */
class Classes {
//--------------------------------------------------------------------------------------------------
private static Object                _lock;

private final Map<String, ClassInfo> _classInfoByClassNameMap;
private static Classes               _classes;
//--------------------------------------------------------------------------------------------------
static {
  _lock = new Object();
} // static initializer
//--------------------------------------------------------------------------------------------------
static Classes getInstance() {
  synchronized (_lock) {
    if (_classes == null) {
      _classes = new Classes();
    }
  }
  return _classes;
} // getInstance()
//--------------------------------------------------------------------------------------------------
private Classes() {
  _classInfoByClassNameMap = Maps.newTreeMap();
} // Classes()
//--------------------------------------------------------------------------------------------------
private ClassInfo addClass(final String packageName, final String className) {
  return addClass(packageName + "." + className);
} // addClass()
//--------------------------------------------------------------------------------------------------
private ClassInfo addClass(final String className) {
  ClassInfo result = _classInfoByClassNameMap.get(className);
  if (result == null) {
    final String[] packageNames = className.split(".");
    result = new ClassInfo(className);
    _classInfoByClassNameMap.put(className, result);
  }
  return result;
} // addClass()
//--------------------------------------------------------------------------------------------------
void load(final ZipFile zipFile) {
  final String classesRootDir = GLConfig.getTopConfigElement().attributeAsString(EConfigAD.ClassesRootDir);
  final Enumeration<? extends ZipEntry> entries = zipFile.entries();
  while (entries.hasMoreElements()) {
    final ZipEntry zipEntry = entries.nextElement();
    final String name = zipEntry.getName();
    if (name.startsWith(classesRootDir) && name.endsWith(".html")) {
      loadClassInfo(zipFile, zipEntry);
    }
  }
} // load()
//--------------------------------------------------------------------------------------------------
private void loadClassInfo(final ZipFile zipFile, final ZipEntry zipEntry) {
  try {
    final InputStream inputStream = zipFile.getInputStream(zipEntry);
    final BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
    try {
      ClassInfo classInfo = null;
      String packageName = null;
      String classDesc = null;
      String line;
      do {
        line = reader.readLine();
        if (line != null) {
          if (line.contains("class=\"subTitle\"")) {
            final int beginIndex = line.indexOf('>');
            if (beginIndex > 0) {
              final int endIndex = line.indexOf('<', beginIndex + 1);
              packageName = line.substring(beginIndex + 1, endIndex);
            }
          }
          else if (packageName != null) {
            if (line.startsWith("<h2 title=")) {
              final int beginIndex = line.indexOf(">Class ");
              if (beginIndex > 0) {
                final int endIndex = line.indexOf('<', beginIndex);
                classInfo = addClass(packageName, line.substring(beginIndex + 7, endIndex));
              }
            }
            else if (classInfo != null) {
              if (line.contains("class=\"inheritance\"")) {
                line = reader.readLine();
                if (line != null && line.contains("<li>")) {
                  loadInheritance(line);
                }
              }
              else if (line.contains("All Implemented Interfaces:")) {
                line = reader.readLine();
                if (line != null && line.contains("<dd>")) {
                  loadInterfaces(classInfo, line);
                }
              }
              else if (classDesc == null && line.contains("class=\"block\"")) {
                do {
                  classDesc = loadClassDesc(classDesc, line);
                  line = reader.readLine();
                } while (line != null && !line.trim().startsWith("<"));
                classInfo.setDesc(classDesc);
              }
            }
          }
        }
      } while (line != null);
    }
    finally {
      reader.close();
    }
  }
  catch (final Exception e) {
    GLLog.major("Failed to load the class file:" + zipEntry.getName(), e);
  }
} // loadClassInfo()
//--------------------------------------------------------------------------------------------------
private String loadClassDesc(final String classDesc, final String line) {
  String result = classDesc == null ? "" : classDesc;
  final int beginIndex = line.indexOf('>') + 1;
  if (beginIndex < line.length()) {
    result += line.substring(beginIndex);
  }
  return result;
} // loadClassDesc()
//--------------------------------------------------------------------------------------------------
private void loadInheritance(final String line) {
  final int beginIndex = line.contains("<li><a") ? line.indexOf('>', 5) + 1 : 4;
  if (beginIndex < 1) {
    return;
  }
  final int endIndex = line.indexOf('<', beginIndex);
  final String className = line.substring(beginIndex, endIndex);
} // loadInheritance()
//--------------------------------------------------------------------------------------------------
private void loadInterfaces(final ClassInfo classInfo, final String line) {
  int beginIndex = 0;
  do {
    beginIndex = line.indexOf('>', beginIndex);
    if (beginIndex > 0 && beginIndex < line.length() - 1 &&
        Character.isJavaIdentifierStart(line.charAt(beginIndex) + 1)) {
      final int endIndex = line.indexOf('<', beginIndex);
      classInfo.addInterface(line.substring(beginIndex + 1, endIndex < 0 ? line.length() : endIndex));
    }
  } while (beginIndex > 0);
} // loadInterfaces()
//--------------------------------------------------------------------------------------------------
}