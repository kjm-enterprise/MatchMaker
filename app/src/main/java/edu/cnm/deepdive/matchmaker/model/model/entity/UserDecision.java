package edu.cnm.deepdive.matchmaker.model.model.entity;

import android.arch.persistence.room.Entity;

/**
 * The entity class for <code>UserDecision</code>.  This sets and gets the items that will be needed to be displayed
 * in the userDecisionDao Interface and sent to the user.
 */
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