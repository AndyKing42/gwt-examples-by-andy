package org.greatlogic.gwtclasses.server;

import java.io.BufferedReader;
import java.io.IOException;
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
 * ... </li> and </ul> tags ...
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
 * <div class="block">A panel that adds user-positioned splitters between each of its childwidgets.
 *  <p>
 */
class Classes {
//--------------------------------------------------------------------------------------------------
private static final String          InterfaceIn = "title=\"interface in ";
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
      String previousInheritanceClass = null;
      String line;
      do {
        line = reader.readLine();
        if (line != null) {
          if (line.contains("class=\"subTitle\"")) {
            packageName = parsePackageNameLine(line);
          }
          else if (packageName != null) {
            if (line.startsWith("<h2 title=")) {
              classInfo = parseClassNameLine(line, packageName);
            }
            else if (classInfo != null) {
              if (line.contains("class=\"inheritance\"")) {
                previousInheritanceClass = parseInheritanceLine(reader.readLine(),
                                                                previousInheritanceClass);
              }
              else if (line.contains("All Implemented Interfaces:")) {
                parseInterfacesline(reader.readLine(), classInfo);
              }
              else if (classInfo.getDesc() == null && line.contains("class=\"block\"")) {
                classInfo.setDesc(parseClassDescLines(line, reader));
              }
            }
          }
        }
      } while (line != null);
      if (classInfo != null && classInfo.getName().endsWith(".Panel")) {
        GLLog.debug("Completed " + classInfo);
      }
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
private String parseClassDescLines(final String line, final BufferedReader reader)
  throws IOException {
  String result = "";
  String line2 = line;
  do {
    final int beginIndex = line2.indexOf('>') + 1;
    if (beginIndex < line2.length()) {
      result += line2.substring(beginIndex);
    }
    line2 = reader.readLine();
  } while (line2 != null && !line2.trim().startsWith("<"));
  return result;
} // parseClassDescLines()
//--------------------------------------------------------------------------------------------------
private ClassInfo parseClassNameLine(final String line, final String packageName) {
  ClassInfo result = null;
  final int beginIndex = line.indexOf(">Class ");
  if (beginIndex > 0) {
    final int endIndex = line.indexOf('<', beginIndex);
    result = addClass(packageName, line.substring(beginIndex + 7, endIndex));
  }
  return result;
} // parseClassNameLine()
//--------------------------------------------------------------------------------------------------
private String parseInheritanceLine(final String line, final String previousInheritanceClass) {
  String result = null;
  if (line == null || !line.contains("<li>")) {
    return result;
  }
  final int beginIndex = line.contains("<li><a") ? line.indexOf('>', 5) + 1 : 4;
  if (beginIndex < 1) {
    return result;
  }
  final int endIndex = line.indexOf('<', beginIndex);
  result = line.substring(beginIndex, endIndex);
  if (previousInheritanceClass != null) {
    final ClassInfo classInfo = addClass(result);
    final ClassInfo parentClassInfo = addClass(previousInheritanceClass);
    classInfo.setParentClassInfo(parentClassInfo);
    parentClassInfo.addChildClassInfo(classInfo);
  }
  return result;
} // parseInheritanceLine()
//--------------------------------------------------------------------------------------------------
/**
 * Extracts the interfaces from the HTML line of the form note that the following lines are actually
 * all on one line in the HTML):
 *   <dd><a href="../../../../../../com/google/gwt/event/logical/shared/HasAttachHandlers.html"
 *   title="interface in com.google.gwt.event.logical.shared">HasAttachHandlers</a>,
 *   <a href="../../../../../../com/google/gwt/event/shared/HasHandlers.html"
 *   title="interface in com.google.gwt.event.shared">HasHandlers</a>,
 *   <a href="../../../../../../com/google/gwt/user/client/EventListener.html"
 *   title="interface in com.google.gwt.user.client">EventListener</a></dd>
 */
private void parseInterfacesline(final String line, final ClassInfo classInfo) {
  if (classInfo.getName().endsWith(".Panel")) {
    GLLog.debug(classInfo.toString());
  }
  if (line != null && line.contains("<dd>")) {
    int beginIndex = 0;
    do {
      beginIndex = line.indexOf(InterfaceIn, beginIndex);
      if (beginIndex > 0) {
        int endIndex = line.indexOf("\">", beginIndex);
        final String packageName = line.substring(beginIndex + InterfaceIn.length(), endIndex);
        beginIndex = endIndex + 2;
        endIndex = line.indexOf('<', beginIndex);
        classInfo.addInterface(packageName + "." + line.substring(beginIndex, endIndex));
      }
    } while (beginIndex > 0);
  }
} // loadInterfaces()
//--------------------------------------------------------------------------------------------------
private String parsePackageNameLine(final String line) {
  String result = null;
  final int beginIndex = line.indexOf('>');
  if (beginIndex > 0) {
    final int endIndex = line.indexOf('<', beginIndex + 1);
    result = line.substring(beginIndex + 1, endIndex);
  }
  return result;
} // parsePackageNameLine()
//--------------------------------------------------------------------------------------------------
}