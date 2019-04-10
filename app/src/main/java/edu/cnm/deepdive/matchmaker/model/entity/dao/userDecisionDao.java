package edu.cnm.deepdive.matchmaker.model.entity.dao;

import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import edu.cnm.deepdive.matchmaker.model.entity.User;

public interface userDecisionDao {

  @Insert(onConflict = OnConflictStrategy.IGNORE)
  Boolean decision(User user);

  @Query("SELECT * FROM User ")
  Boolean decision ();
}
