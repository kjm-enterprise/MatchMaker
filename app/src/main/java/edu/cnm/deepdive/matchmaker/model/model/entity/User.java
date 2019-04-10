package edu.cnm.deepdive.matchmaker.model.model.entity;

import android.arch.persistence.room.Entity;
import android.media.Image;
import java.util.UUID;
import com.google.gson.annotations.Expose;

/**
 * The entity class for <code>User</code>. This class sets and gets info to be sent to the Dao classes
 * and accessed by the users.
 */
@Entity
public class User {

  @Expose
  public UUID id;
  @Expose
  public String googleSubjectId;
  @Expose
  public String firstName;
  @Expose
  public  String lastName;
  @Expose
  public String email;
  @Expose
  public Enum preferences;
  @Expose
  public Long matchedUsers;
  @Expose
  public Long messageId;
  @Expose
  public String userBio;
  @Expose
  public Image userImage;

  public Long imageId;

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public String getGoogleSubjectId() {
    return googleSubjectId;
  }

  public void setGoogleSubjectId(String googleSubjectId) {
    this.googleSubjectId = googleSubjectId;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Enum getPreferences() {
    return preferences;
  }

  public void setPreferences(Enum preferences) {
    this.preferences = preferences;
  }

  public Long getMatchedUsers() {
    return matchedUsers;
  }

  public void setMatchedUsers(Long matchedUsers) {
    this.matchedUsers = matchedUsers;
  }

  public Long getMessageId() {
    return messageId;
  }

  public void setMessageId(Long messageId) {
    this.messageId = messageId;
  }

  public String getUserBio() {
    return userBio;
  }

  public void setUserBio(String userBio) {
    this.userBio = userBio;
  }

  public Image getUserImage() {
    return userImage;
  }

  public void setUserImage(Image userImage) {
    this.userImage = userImage;
  }

  public Long getImageId() {
    return imageId;
  }

  public void setImageId(Long imageId) {
    this.imageId = imageId;
  }

}
