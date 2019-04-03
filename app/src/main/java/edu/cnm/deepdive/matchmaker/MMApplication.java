package edu.cnm.deepdive.matchmaker;

import android.app.Application;

public class MMApplication extends Application {

  private static MMApplication instance = null;

  @Override
  public void onCreate() {
    super.onCreate();
    instance = this;
  }

  public static MMApplication getInstance() {
    return instance;
  }
}
