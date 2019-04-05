package edu.cnm.deepdive.matchmaker.model.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity
public class UserDecision {

  public Long byUserId;

  public Long reUserId;

  public Boolean selection;

  public Long getByUserId() {
    return byUserId;
  }

  public void setByUserId(Long byUserId) {
    this.byUserId = byUserId;
  }

  public Long getReUserId() {
    return reUserId;
  }

  public void setReUserId(Long reUserId) {
    this.reUserId = reUserId;
  }

  public Boolean getSelection() {
    return selection;
  }

  public void setSelection(Boolean selection) {
    this.selection = selection;
  }
}