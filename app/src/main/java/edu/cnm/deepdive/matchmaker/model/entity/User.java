package edu.cnm.deepdive.matchmaker.model.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity
public class User {

  @PrimaryKey
  @NonNull
  long _id;
  String _name;
  String _email;
  Long _preferences;
  Long _messages;
  Long matches;

  public User() {
  }

  public User(int _id, Long _messages, String _name, String _email, Long _preferences, Long matches) {
    this._id = _id;
    this._email = _email;
    this._name = _name;
    this._preferences = _preferences;
    this._messages = _messages;
    this.matches = matches;
  }

  public User(Long _messages, String _name, String _email) {
    this._messages = _messages;
    this._name = _name;
    this._email = _email;
  }

  public long get_id() {
    return _id;
  }

  public void set_id(long _id) {
    this._id = _id;
  }

  public String get_name() {
    return _name;
  }

  public void set_name(String _name) {
    this._name = _name;
  }

  public String get_email() {
    return _email;
  }

  public void set_email(String _email) {
    this._email = _email;
  }

  public Long get_preferences() {
    return _preferences;
  }

  public void set_preferences(Long _preferences) {
    this._preferences = _preferences;
  }

  public Long get_messages() {
    return _messages;
  }

  public void set_messages(Long _messages) {
    this._messages = _messages;
  }

  public Long getMatches() {
    return matches;
  }

  public void setMatches(Long matches) {
    this.matches = matches;
  }
}
