package org.greatlogic.gwtclasses.server;

class PackageInfo {
//--------------------------------------------------------------------------------------------------
private String       _desc;
private final String _name;
//--------------------------------------------------------------------------------------------------
PackageInfo(final String name) {
  _name = name;
  _desc = "";
} // PackageInfo()
//--------------------------------------------------------------------------------------------------
String getDesc() {
  return _desc;
} // getDesc()
//--------------------------------------------------------------------------------------------------
String getName() {
  return _name;
} // getName()
//--------------------------------------------------------------------------------------------------
void setDesc(final String desc) {
  _desc = desc;
} // setDesc;
//--------------------------------------------------------------------------------------------------
@Override
public String toString() {
  return "Package:" + _name;
} // toString()
//--------------------------------------------------------------------------------------------------
}