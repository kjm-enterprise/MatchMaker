package edu.cnm.deepdive.matchmaker.controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;
import edu.cnm.deepdive.matchmaker.R;
import edu.cnm.deepdive.matchmaker.service.FragmentService;
import edu.cnm.deepdive.matchmaker.service.GoogleSignInService;


/**
 *
 *Copyright 2019 KJM Enterprise
 *
 *Licensed under the Apache Licences Version 2.0 (the "License"); you may not use
 *this file except in compliance with the Licenses.

 *[Link To License](http://www.apache.org/licenses/LICENSE-2.0)

 *Unless required by applicable law or agreed to in writing, software distributed under the License
 *is distributed on an as is basis, without warranties or conditions of any kind, wither express or
 *implied. See the language governing permissions and limitations under the License.

 */
public class MainActivity extends AppCompatActivity {

  private static final String TAG = "MainActivity";
  private TextView textMessage;

  private BottomNavigationView.OnNavigationItemSelectedListener onNavigationItemSelectedListener
      = new BottomNavigationView.OnNavigationItemSelectedListener() {

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
      FragmentService fragmentService = FragmentService.getInstance();
      boolean handled = true;
      switch (item.getItemId()) {
        case R.id.fragment_find_someone:
          loadFragment(new FindSomeoneFragment(), "find_someone");
          break;
        case R.id.fragment_matches:
          loadFragment(new MatchesFragment(), "matches");
          break;
        case R.id.fragment_messages:
          loadFragment(new MessageFragment(), "message");
          break;
        case R.id.fragment_user_profile:
          loadFragment(new UserProfileFragment(), "user_profile");
          break;
        default:
          handled = false;
      }
      return handled;
    }
  };


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
    navigation.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener);

    Fragment fragmentFindSomeone = new FindSomeoneFragment();

    FragmentManager manager = getSupportFragmentManager();
    FragmentTransaction transaction = manager.beginTransaction();
    transaction.add(R.id.fragment_container, fragmentFindSomeone, "find_someone");
    transaction.commit();

    FirebaseInstanceId.getInstance().getToken();

  }

  public void loadFragment(Fragment fragment, String tag) {
    FragmentManager manager = getSupportFragmentManager();
    manager.beginTransaction()
        .add(R.id.fragment_container, fragment, tag)
        .commit();
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    MenuInflater inflater = getMenuInflater();
    inflater.inflate(R.menu.options_menu, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    boolean handeled = true;
    if (item.getItemId() == R.id.sign_out) {
      signOut();
    } else {
      handeled = super.onOptionsItemSelected(item);
    }
    return handeled;
  }

  private void signOut() {
    GoogleSignInService.getInstance().getClient()
        .signOut()
        .addOnCompleteListener(this, (task -> {
          GoogleSignInService.getInstance().setAccount(null);
          Intent intent = new Intent(this, LoginActivity.class);
          intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
          startActivity(intent);
        }));
  }


  public void onClick(View v) {
    // Get token
    // [START retrieve_current_token]
    FirebaseInstanceId.getInstance().getInstanceId()
        .addOnCompleteListener(new OnCompleteListener<InstanceIdResult>() {
          @Override
          public void onComplete(@NonNull Task<InstanceIdResult> task) {
            if (!task.isSuccessful()) {
              Log.w(TAG, "getInstanceId failed", task.getException());
              return;
            }

            // Get new Instance ID token
            String token = task.getResult().getToken();

            // Log and toast
            String msg = getString(R.string.msg_token_fmt, token);
            Log.d(TAG, msg);
            Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
          }
        });
    // [END retrieve_current_token]
  }

}