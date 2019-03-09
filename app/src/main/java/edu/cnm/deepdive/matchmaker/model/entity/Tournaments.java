package edu.cnm.deepdive.matchmaker.model.entity;

import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

public class Tournaments {

  @PrimaryKey
  @NonNull
  long _tournament_id;
  String _location;
  String _game;
  Long _participants;

  public Tournaments() {
  }

  public Tournaments(int _tournament_id, Long _participants, String _location, String _game) {
    this._tournament_id = _tournament_id;
    this._location = _location;
    this._game = _game;
    this._participants = _participants;
  }

  public Tournaments(Long _participants, String _location, String _game) {
    this._participants = _participants;
    this._game = _game;
    this._location = _location;
  }


  public String get_location() {
    return _location;
  }

  public void set_location(String _location) {
    this._location = _location;
  }

  public String get_game() {
    return _game;
  }

  public void set_game(String _game) {
    this._game = _game;
  }

  public Long get_participants() {
    return _participants;
  }

  public void set_participants(Long _participants) {
    this._participants = _participants;
  }
}


