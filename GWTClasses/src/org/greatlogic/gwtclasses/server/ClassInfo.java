package org.greatlogic.gwtclasses.server;

import java.util.Set;
import org.greatlogic.gwtclasses.server.IServerEnums.ELanguageConstruct;
import com.google.common.collect.Sets;

class ClassInfo implements Comparable<ClassInfo> {
//--------------------------------------------------------------------------------------------------
private final Set<ClassInfo> _childClassInfoSet;
private String               _desc;
private final Set<String>    _interfaceNameSet;
private boolean              _isAbstract;
private ELanguageConstruct   _languageConstruct;
private final String         _name;
private ClassInfo            _parentClassInfo;
//--------------------------------------------------------------------------------------------------
ClassInfo(final String name) {
  _name = name;
  _childClassInfoSet = Sets.newTreeSet();
  _interfaceNameSet = Sets.newTreeSet();
} // PackageInfo()
//--------------------------------------------------------------------------------------------------
void addChildClassInfo(final ClassInfo childClassInfo) {
  _childClassInfoSet.add(childClassInfo);
} // addChildClassInfo()
//--------------------------------------------------------------------------------------------------
void addInterface(final String interfaceName) {
  _interfaceNameSet.add(interfaceName);
} // addInterface()
//--------------------------------------------------------------------------------------------------
@Override
public int compareTo(final ClassInfo classInfo) {
  return _name.compareTo(classInfo._name);
} // compareTo()
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
} // setDesc()
//--------------------------------------------------------------------------------------------------
void setIsAbstract(final boolean isAbstract) {
  _isAbstract = isAbstract;
} // setIsAbstract()
//--------------------------------------------------------------------------------------------------
void setLanguageConstruct(final ELanguageConstruct languageConstruct) {
  _languageConstruct = languageConstruct;
} // setLanguageConstruct()
//--------------------------------------------------------------------------------------------------
void setParentClassInfo(final ClassInfo parentClassInfo) {
  _parentClassInfo = parentClassInfo;
} // setParentClassInfo()
//--------------------------------------------------------------------------------------------------
@Override
public String toString() {
  return "Class:" + _name + (_parentClassInfo == null ? "" : " Parent:" + _parentClassInfo._name);
} // toString()
//--------------------------------------------------------------------------------------------------
}