package org.greatlogic.runtimecssexample.server;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import com.greatlogic.glbase.gllib.GLLog;
import com.greatlogic.glbase.gllib.GLUtil;
import com.greatlogic.glbase.gllib.IGLProgram;

public class RCSSEServletContextListener implements ServletContextListener {
//==================================================================================================
private static class RCSSEProgram implements IGLProgram {
@Override
public boolean displayCommandLineHelp() {
  return false;
} // displayCommandLineHelp()
} // class RCSSEProgram
//==================================================================================================
@Override
public void contextDestroyed(final ServletContextEvent event) {
  //
}
//--------------------------------------------------------------------------------------------------
@Override
public void contextInitialized(final ServletContextEvent event) {
  final String configFilename = "RCSSE.cfg";
  GLUtil.initializeProgram(new RCSSEProgram(), null, null, //
                           "<args ConfigFilename='" + configFilename + "'/>");
  GLLog.debug("hi");
}
//--------------------------------------------------------------------------------------------------
}