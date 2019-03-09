package edu.cnm.deepdive.matchmaker.model.entity;

import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

public class MeetUp {

  @PrimaryKey
  @NonNull
  long _meetup_id;
  String _meetup_header;
  String _meetup_location;
  String _meetup_summary;

  public MeetUp() {
  }

  public MeetUp(int _meetup_id, String _meetup_summary, String _meetup_header, String _meetup_location) {
    this._meetup_id = _meetup_id;
    this._meetup_header = _meetup_header;
    this._meetup_location = _meetup_location;
    this._meetup_summary = _meetup_summary;
  }

  public MeetUp(String _meetup_summary, String _meetup_header, String _meetup_location) {
    this._meetup_summary = _meetup_summary;
    this._meetup_location = _meetup_location;
    this._meetup_header = _meetup_header;
  }


  public String get_meetup_header() {
    return _meetup_header;
  }

  public void set_meetup_header(String _meetup_header) {
    this._meetup_header = _meetup_header;
  }

  public String get_meetup_location() {
    return _meetup_location;
  }

  public void set_meetup_location(String _meetup_location) {
    this._meetup_location = _meetup_location;
  }

  public String get_meetup_summary() {
    return _meetup_summary;
  }

  public void set_meetup_summary(String _meetup_summary) {
    this._meetup_summary = _meetup_summary;
  }
}

