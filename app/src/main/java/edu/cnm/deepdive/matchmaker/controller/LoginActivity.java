package edu.cnm.deepdive.matchmaker.controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;
import edu.cnm.deepdive.matchmaker.R;
import edu.cnm.deepdive.matchmaker.service.GoogleSignInService;

/**
 * <code>LoginActivity</code> allows the user to login using google signin.
 */
public class LoginActivity extends AppCompatActivity {

  private static final int LOGIN_REQUEST_CODE = 1000;

  /**
   * <code>onCreate</code> creates the instance to be inflated in the layouyt
   *
   * @param savedInstanceState saves the instanace of the layout once inflated.
   */
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_login);
    SignInButton signIn = findViewById(R.id.sign_in);
    signIn.setOnClickListener((v) -> signIn());
  }

  /**
   * checks to see if an account was previously signed into at the start of the application.  If it
   * was then it switches over to that account.
   */
  @Override
  protected void onStart() {
    super.onStart();
    GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);
    if (account != null) {
      GoogleSignInService.getInstance().setAccount(account);
      switchToMain();
    }
  }

  @Override
  protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
    if (requestCode == LOGIN_REQUEST_CODE) {
      try {
        Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
        GoogleSignInAccount account = task.getResult(ApiException.class);
        GoogleSignInService.getInstance().setAccount(account);
        switchToMain();
      } catch (ApiException e) {
        Toast.makeText(this, R.string.sign_in_fail, Toast.LENGTH_LONG)
            .show();
      }
    }
  }

  /**
   * If an account was not signed in it sends a request to sign in.
   */
  private void signIn() {
    Intent intent = GoogleSignInService.getInstance().getClient().getSignInIntent();
    startActivityForResult(intent, LOGIN_REQUEST_CODE);
  }

  /**
   * After the account has been signed in it then switches to the <code>MainActivity</code>
   */
  private void switchToMain() {
    Intent intent = new Intent(this, MainActivity.class);
    intent.addFlags((Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK));
    startActivity(intent);
  }
}
