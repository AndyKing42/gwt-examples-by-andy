package org.greatlogic.rfexample2.server;

import com.greatlogic.glbase.gllib.GLConfig;
import com.greatlogic.glbase.gllib.GLEmailer;
import com.greatlogic.glbase.gllib.GLUtil;
import com.greatlogic.glbase.gllib.IGLProgram;
import com.greatlogic.glbase.glxml.GLXMLElement;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import org.greatlogic.rfexample2.server.RFEServerEnums.ERFEConfigAttribute;
import org.greatlogic.rfexample2.server.model.dao.BookClubDAOLocator;

public class RFEServletContextListener implements ServletContextListener {
//==================================================================================================
private static class RFEProgram implements IGLProgram {
@Override
public boolean displayCommandLineHelp() {
  return false;
} // displayCommandLineHelp()
} // class RFEProgram
//==================================================================================================
@Override
public void contextDestroyed(final ServletContextEvent event) {
  //
} // contextDestroyed()
//--------------------------------------------------------------------------------------------------
@Override
public void contextInitialized(final ServletContextEvent event) {
  String configFilename = event.getServletContext().getInitParameter("ConfigFilename");
  GLUtil.initializeProgram(new RFEProgram(), null, null, //
                           "<args ConfigFilename='" + configFilename + "'/>");
  GLEmailer emailer = new GLEmailer(GLConfig.getTopConfigElement());
  initializeExternalIPChecker(emailer);
  initializeDAOs();
} // contextInitialized()
//--------------------------------------------------------------------------------------------------
private void initializeDAOs() {
  BookClubDAOLocator.getBookClubDAO();
} // initializeDAOs()
//--------------------------------------------------------------------------------------------------
private void initializeExternalIPChecker(final GLEmailer emailer) {
  GLXMLElement configElement = GLConfig.getTopConfigElement();
  int intervalSeconds = configElement.attributeAsInt(ERFEConfigAttribute.ExternalIPCheckerIntervalSeconds);
  String emailFrom = configElement.attributeAsString(ERFEConfigAttribute.ExternalIPCheckerEmailFrom);
  String emailTo = configElement.attributeAsString(ERFEConfigAttribute.ExternalIPCheckerEmailTo);
  String saveToFilename = configElement.attributeAsString(ERFEConfigAttribute.ExternalIPCheckerSaveToFilename);
  if (intervalSeconds > 0 && !emailTo.isEmpty() && !saveToFilename.isEmpty()) {
    new ExternalIPChecker(intervalSeconds, emailer, emailFrom, emailTo, saveToFilename);
  }
} // initializeExternalIPChecker()
//--------------------------------------------------------------------------------------------------
}