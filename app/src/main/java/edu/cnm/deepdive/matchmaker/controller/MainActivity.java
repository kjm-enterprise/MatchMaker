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
 * Copyright 2019 KJM Enterprise
 *
 * Licensed under the Apache Licences Version 2.0 (the "License"); you may not use this file except
 * in compliance with the Licenses.
 *
 * [Link To License](http://www.apache.org/licenses/LICENSE-2.0)
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an as is basis, without warranties or conditions of any kind, wither express or
 * implied. See the language governing permissions and limitations under the License.
 *
 * @author Michael Sanchez, Kanyon Wyman and James Mattos
 * @Version 1.0
 * The <code>MainActivity</code> is the start of the entire application.  It calls different methods and
 * allows them to launch by connecting them through the <code>MainActivity</code>
 */
public class MainActivity extends AppCompatActivity {

  private static final String TAG = "MainActivity";


  /**
   * The <code>onNavigationItemSelected</code> method allows the app to launch the different fragments that
   * are called through the app.
   */
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

  /**
   * OnCreate starts the lifecycle of the app and inflates all of the needed XML files and calls the
   * fragment manager to start the app in the apps home fragment.
   *
   * @param savedInstanceState saves the instance which the app creates.
   */
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


  }

  /**
   * Initializes the fragments ability to be loaded in <code>onCreate</code>
   *
   * @param fragment the individual sections of the app.
   * @param tag refers to the tag that the apps are referenced as in<code>onNavigationItemsSelected</code>
   */
  public void loadFragment(Fragment fragment, String tag) {
    FragmentManager manager = getSupportFragmentManager();
    manager.beginTransaction()
        .add(R.id.fragment_container, fragment, tag)
        .commit();
  }

  /**
   * This tells the compiler to inflate the options menu that sits atop the app.  It houses the
   * signout feature.
   *
   * @param menu simply just a menu item
   * @return returns true when obtaining the <code>onCreateOptionsMenu</code>
   */
  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    MenuInflater inflater = getMenuInflater();
    inflater.inflate(R.menu.options_menu, menu);
    return true;
  }

  /**
   * This tells the compiler how to handle <code>onCreateOptionsMenu</code> when an item is selected
   * in the options menu.
   */
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

  /**
   * WHen the item is selected this informs <code>GoogleSignInService</code> to create a new task
   * and sign out.
   */
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

  /**
   *  This method currently does nothing with the app.  However it will be used to generate a token between devices
   *  to allow them to communicate together.
   */
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