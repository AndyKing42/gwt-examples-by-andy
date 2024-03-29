package org.greatlogic.rfexample2.server.model.dao;

import java.util.List;
import org.greatlogic.rfexample2.server.model.dto.BookClub;

public interface IBookClubDAO {
//--------------------------------------------------------------------------------------------------
public BookClub findById(final Integer id);
public void save(final BookClub bookClub);
public List<BookClub> selectAllBookClubs();
//--------------------------------------------------------------------------------------------------
}