package edu.cnm.deepdive.matchmaker.controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import edu.cnm.deepdive.matchmaker.R;
import edu.cnm.deepdive.matchmaker.service.FragmentService;
import edu.cnm.deepdive.matchmaker.service.GoogleSignInService;

public class MainActivity extends AppCompatActivity {

  private TextView textMessage;

  private BottomNavigationView.OnNavigationItemSelectedListener onNavigationItemSelectedListener
      = new BottomNavigationView.OnNavigationItemSelectedListener() {

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
      FragmentService fragmentService = FragmentService.getInstance();
      boolean handled = true;
      switch (item.getItemId()) {
        case R.id.fragment_find_someone:
         loadFragment(new FindSomeoneFragment(),"find_someone");
          break;
        case R.id.fragment_matches:
          loadFragment(new MatchesFragment(), "matches");
         /* textMessage.setText(R.string.matches);*/
          break;
        case R.id.fragment_messages:
          loadFragment(new MessageFragment(), "message");
          /*textMessage.setText(R.string.messages );*/
          break;
        case R.id.fragment_user_profile:
          loadFragment(new UserProfileFragment(), "user_profile");
          default:
            handled= false;
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
  }

  public void loadFragment(Fragment fragment, String tag) {
    FragmentManager manager = getSupportFragmentManager();
    manager.beginTransaction()
        .add(R.id.fragment_container,fragment, tag)
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

}
