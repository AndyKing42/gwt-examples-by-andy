package org.greatlogic.rfexample2.server;

import com.greatlogic.glbase.gldb.GLDBException;
import com.greatlogic.glbase.gldb.GLDBUtil;
import com.greatlogic.glbase.gldb.IGLColumn;
import com.greatlogic.glbase.gldb.IGLTable;
import com.greatlogic.glbase.glxml.IGLXMLAttributeEnum;

public class RFEServerEnums {
//--------------------------------------------------------------------------------------------------
public enum ERFEConfigAttribute implements IGLXMLAttributeEnum {
ExternalIPCheckerEmailFrom,
ExternalIPCheckerEmailTo,
ExternalIPCheckerIntervalSeconds,
ExternalIPCheckerSaveToFilename
} // enum ERFEConfigAttribute
//--------------------------------------------------------------------------------------------------
public enum ERFExampleSequence {
UserId(1);
private int _id;
private ERFExampleSequence(final int id) {
  _id = id;
} // enum ERFExampleSequence
public int getId() {
  return _id;
} // getId()
public int getNextValue(final int numberOfValues) throws GLDBException {
  return (int)GLDBUtil.getNextSequenceValue(name(), ERFExampleTable.DBSequence,
                                            DBSequenceCol.NextValue, DBSequenceCol.Id + "=" + _id,
                                            numberOfValues);
} // getNextValue()
} // enum ERFExampleSequence
//--------------------------------------------------------------------------------------------------
public enum ERFExampleTable implements IGLTable {
BookClub(BookClubCol.class),
DBSequence(DBSequenceCol.class),
User(UserCol.class);
private Class<? extends Enum<?>> _columnEnumClass;
private ERFExampleTable(final Class<? extends Enum<?>> columnEnumClass) {
  _columnEnumClass = columnEnumClass;
  GLDBUtil.registerTable(this);
} // ECirrusTable()
@Override
public String getAbbrev() {
  return _columnEnumClass.getSimpleName();
} // getAbbrev()
@Override
public Class<? extends Enum<?>> getColumnEnumClass() {
  return _columnEnumClass;
} // getColumnEnumClass()
@Override
public String getDataSourceName() {
  return null;
} // getDataSourceName()
} // enum ERFExampleTable
//--------------------------------------------------------------------------------------------------
public enum BookClubCol implements IGLColumn {
BookClubDesc,
BookClubName,
Id,
ModifiedDateTime,
ModifiedUserId,
Version
} // enum BookClubCol
//--------------------------------------------------------------------------------------------------
public enum DBSequenceCol implements IGLColumn {
Id,
NextValue
} // enum DBSequenceCol
//--------------------------------------------------------------------------------------------------
public enum UserCol implements IGLColumn {
Id,
PasswordHash,
UserId,
Version
} // enum UserCol
//--------------------------------------------------------------------------------------------------
}