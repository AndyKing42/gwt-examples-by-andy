package org.greatlogic.gxtexample1.server.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BookClub implements Comparable<BookClub> {
//--------------------------------------------------------------------------------------------------
@Column(length = 200, name = "Desc", nullable = false)
private String  _desc;
@Column(name = "Id", nullable = false, unique = true)
@Id
private Integer _id;
@Column(length = 14, name = "ModifiedDateTime", nullable = false)
private String  _modifiedDateTime;
@Column(length = 50, name = "ModifiedUserId", nullable = false)
private String  _modifiedUserId;
@Column(length = 50, name = "Name", nullable = false)
private String  _name;
@Column(name = "Version", nullable = false)
private Integer _version;
//--------------------------------------------------------------------------------------------------
public BookClub() {
  // used by the GWT request factory
} // BookClub()
//--------------------------------------------------------------------------------------------------
public BookClub(final String desc, final int id, final String name, final int version) {
  _desc = desc;
  _id = id;
  _name = name;
  _version = version;
} // BookClub()
//--------------------------------------------------------------------------------------------------
@Override
public int compareTo(final BookClub org) {
  return _name.compareToIgnoreCase(org._name);
} // compareTo()
//--------------------------------------------------------------------------------------------------
public String getDesc() {
  return _desc;
} // getDesc()
//--------------------------------------------------------------------------------------------------
public int getId() {
  return _id;
} // getId()
//--------------------------------------------------------------------------------------------------
public String getModifiedDateTime() {
  return _modifiedDateTime;
} // getModifiedDateTime()
//--------------------------------------------------------------------------------------------------
public String getModifiedUserId() {
  return _modifiedUserId;
} // getModifiedUserId()
//--------------------------------------------------------------------------------------------------
public String getName() {
  return _name;
} // getName()
//--------------------------------------------------------------------------------------------------
public int getVersion() {
  return _version == null ? 0 : _version;
} // getVersion()
//--------------------------------------------------------------------------------------------------
public void setDesc(final String desc) {
  _desc = desc;
} // setDesc()
//--------------------------------------------------------------------------------------------------
public void setId(final Integer id) {
  _id = id;
} // setId()
//--------------------------------------------------------------------------------------------------
public void setModifiedDateTime(final String modifiedDateTime) {
  _modifiedDateTime = modifiedDateTime;
} // setModifiedDateTime()
//--------------------------------------------------------------------------------------------------
public void setModifiedUserId(final String modifiedUserId) {
  _modifiedUserId = modifiedUserId;
} // setModifiedUserId()
//--------------------------------------------------------------------------------------------------
public void setName(final String name) {
  _name = name;
} // setName
//--------------------------------------------------------------------------------------------------
public void setVersion(final Integer version) {
  _version = version;
} // setVersion()
//--------------------------------------------------------------------------------------------------
}