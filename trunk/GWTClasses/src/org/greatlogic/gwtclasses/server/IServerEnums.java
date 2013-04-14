package org.greatlogic.gwtclasses.server;

import com.greatlogic.glbase.glxml.IGLXMLAttributeEnum;

interface IServerEnums {
//--------------------------------------------------------------------------------------------------
enum EConfigAD implements IGLXMLAttributeEnum {
ClassesRootDir,
JavadocZIPFilename,
PackagesHTMLFilename
} // enum EConfigAD
//--------------------------------------------------------------------------------------------------
enum ELanguageConstruct {
Class,
Enum,
Interface,
Unknown
} // enum ELanguageConstruct
//--------------------------------------------------------------------------------------------------
}