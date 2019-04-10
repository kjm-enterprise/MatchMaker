package edu.cnm.deepdive.matchmaker.service;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import edu.cnm.deepdive.matchmaker.MMApplication;
import edu.cnm.deepdive.matchmaker.R;

/**
 * This service is used to allow he user to sign in with google sign in and has a relationship with
 * the <code>LoginActivity</code> and thus the <code>MainActivity</code>.  The class also establishes setters
 * and getters that the sign in service needs to operate.
 */
public class GoogleSignInService {

  private GoogleSignInClient client;
  private GoogleSignInAccount account;

  /**
   * Begins the sign in proccess by requesting an email, Id, and token that was supplied by the
   * Google cloud console.
   */
  private GoogleSignInService() {
    GoogleSignInOptions options =
        new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestEmail()
            .requestId()
            .requestIdToken(MMApplication.getInstance().getString(R.string.client_id))
            .build();
    client = GoogleSignIn.getClient(MMApplication.getInstance(), options);
  }

  public static GoogleSignInService getInstance() {
    return InstanceHolder.INSTANCE;
  }

  public GoogleSignInClient getClient() {
    return client;
  }

  public void setClient(GoogleSignInClient client) {
    this.client = client;
  }

  public GoogleSignInAccount getAccount() {
    return account;
  }

  public void setAccount(GoogleSignInAccount account) {
    this.account = account;
  }

  private static class InstanceHolder {

    private static final GoogleSignInService INSTANCE = new GoogleSignInService();
  }

}

