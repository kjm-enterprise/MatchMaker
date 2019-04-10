package edu.cnm.deepdive.matchmaker.model.entity.dao;

import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import edu.cnm.deepdive.matchmaker.model.entity.User;
import java.util.List;

public interface userDao {

  @Insert
  List<String> insert(User users);

  @Query
      ("SELECT * FROM User")
  List<User> findAll();

}
