package org.greatlogic.gwtclasses.server;

import java.util.List;
import com.google.common.collect.Lists;

class ClassInfo {
//--------------------------------------------------------------------------------------------------
private String             _desc;
private final List<String> _interfaceNameList;
private final String       _name;
//--------------------------------------------------------------------------------------------------
ClassInfo(final String name) {
  _name = name;
  _interfaceNameList = Lists.newArrayList();
} // PackageInfo()
//--------------------------------------------------------------------------------------------------
void addInterface(final String interfaceName) {
  _interfaceNameList.add(interfaceName);
} // addInterface()
//--------------------------------------------------------------------------------------------------
String getName() {
  return _name;
} // getName()
//--------------------------------------------------------------------------------------------------
void setDesc(final String desc) {
  _desc = desc;
} // setDesc()
//--------------------------------------------------------------------------------------------------
}