package org.greatlogic.rfexample1.server.model;

import java.util.List;

public interface IBookClubDAO {
//--------------------------------------------------------------------------------------------------
public BookClub findById(final Integer id);
public void save(final BookClub bookClub);
public List<BookClub> selectAllBookClubs();
//--------------------------------------------------------------------------------------------------
}