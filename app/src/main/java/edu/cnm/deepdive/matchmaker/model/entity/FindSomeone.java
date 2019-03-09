package edu.cnm.deepdive.matchmaker.model.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity
public class FindSomeone {

  @PrimaryKey
  @NonNull
  long _match_id;
  String _user_bio;
  Long _user_image_number;
  Long _user_id;

  public FindSomeone() {
  }

  public FindSomeone(int _match_id, Long _user_id, String _user_bio, Long _user_image_number) {
    this._match_id = _match_id;
    this._user_bio = _user_bio;
    this._user_image_number = _user_image_number;
    this._user_id = _user_id;
  }

  public FindSomeone(Long _user_id, String _user_bio, Long _user_image_number) {
    this._user_id = _user_id;
    this._user_image_number = _user_image_number;
    this._user_bio = _user_bio;
  }


  public String get_user_bio() {
    return _user_bio;
  }

  public void set_user_bio(String _user_bio) {
    this._user_bio = _user_bio;
  }

  public Long get_user_image_number() {
    return _user_image_number;
  }

  public void set_user_image_number(Long _user_image_number) {
    this._user_image_number = _user_image_number;
  }

  public Long get_user_id() {
    return _user_id;
  }

  public void set_user_id(Long _user_id) {
    this._user_id = _user_id;
  }
}