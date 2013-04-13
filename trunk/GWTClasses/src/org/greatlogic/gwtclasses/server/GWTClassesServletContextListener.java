package org.greatlogic.gwtclasses.server;

import java.io.IOException;
import java.util.zip.ZipFile;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import org.greatlogic.gwtclasses.server.IServerEnums.EConfigAD;
import com.greatlogic.glbase.gllib.GLConfig;
import com.greatlogic.glbase.gllib.GLLog;
import com.greatlogic.glbase.gllib.GLUtil;
import com.greatlogic.glbase.gllib.IGLProgram;
import com.greatlogic.glbase.glxml.GLXMLElement;

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
  final GLXMLElement configElement = GLConfig.getTopConfigElement();
  final String javadocFilename = configElement.attributeAsString(EConfigAD.JavadocZIPFilename);
  try {
    final ZipFile zipFile = new ZipFile(javadocFilename);
    try {
      if (Packages.getInstance().load(zipFile)) {
        Classes.getInstance().load(zipFile);
      }
    }
    finally {
      zipFile.close();
    }
  }
  catch (final IOException ioe) {
    GLLog.major("Failed to open Javadoc file:" + javadocFilename, ioe);
  }
} // contextInitialized()
//--------------------------------------------------------------------------------------------------
}