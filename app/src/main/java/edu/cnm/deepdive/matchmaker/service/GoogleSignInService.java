package edu.cnm.deepdive.matchmaker.service;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import edu.cnm.deepdive.matchmaker.MMApplication;
import edu.cnm.deepdive.matchmaker.R;

public class GoogleSignInService {

  private GoogleSignInClient client;
  private GoogleSignInAccount account;

  private GoogleSignInService() {
    GoogleSignInOptions options = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
        .requestEmail()
        .requestId()
        .requestIdToken(MMApplication.getInstance().getString(R.string.client_id))
        .build();
    client = GoogleSignIn.getClient(MMApplication.getInstance(), options);
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

  private static class InstanceHoleder {

    private static final GoogleSignInService INSTANCE = new GoogleSignInService();
  }

  }
