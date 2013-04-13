package org.greatlogic.gwtclasses.server;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import com.greatlogic.glbase.gllib.GLUtil;
import com.greatlogic.glbase.gllib.IGLProgram;

public class GWTClassesServletContextListener implements ServletContextListener {
//==================================================================================================
private static class GWTClassesProgram implements IGLProgram {
@Override
public boolean displayCommandLineHelp() {
  return false;
} // displayCommandLineHelp()
} // class GWTClassesProgram
//==================================================================================================
@Override
public void contextDestroyed(final ServletContextEvent event) {
  //
} // contextDestroyed()
//--------------------------------------------------------------------------------------------------
@Override
public void contextInitialized(final ServletContextEvent event) {
  final String configFilename = event.getServletContext().getInitParameter("ConfigFilename");
  GLUtil.initializeProgram(new GWTClassesProgram(), null, null, //
                           "<args ConfigFilename='" + configFilename + "'/>");
} // contextInitialized()
//--------------------------------------------------------------------------------------------------
}