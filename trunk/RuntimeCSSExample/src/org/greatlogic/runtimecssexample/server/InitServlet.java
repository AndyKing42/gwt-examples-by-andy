package org.greatlogic.runtimecssexample.server;

import java.io.IOException;
import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import com.google.common.collect.ImmutableSet;
import com.google.common.reflect.ClassPath;
import com.google.common.reflect.ClassPath.ClassInfo;
import com.google.gwt.user.client.ui.UIObject;
import com.greatlogic.glbase.gllib.GLLog;
import com.greatlogic.glbase.gllib.GLUtil;
import com.greatlogic.glbase.gllib.IGLProgram;

public class InitServlet extends GenericServlet {
//==================================================================================================
private static class RCSSEProgram implements IGLProgram {
@Override
public boolean displayCommandLineHelp() {
  return false;
} // displayCommandLineHelp()
} // class RCSSEProgram
//==================================================================================================
@Override
public void init() {
  final String configFilename = "RCSSE.cfg";
  GLUtil.initializeProgram(new RCSSEProgram(), null, null, //
                           "<args ConfigFilename='" + configFilename + "'/>");
  ClassPath classPath;
  try {
    classPath = ClassPath.from(UIObject.class.getClassLoader());
    final ImmutableSet<ClassInfo> classInfoSet = classPath.getTopLevelClassesRecursive(UIObject.class.getName());
    GLLog.debug(classInfoSet.toString());
  }
  catch (final IOException ioe) {
    GLLog.minor("Error using ClassPath", ioe);
  }
}
//--------------------------------------------------------------------------------------------------
@Override
public void service(final ServletRequest request, final ServletResponse response)
  throws ServletException, IOException {
  //
}
//--------------------------------------------------------------------------------------------------
}