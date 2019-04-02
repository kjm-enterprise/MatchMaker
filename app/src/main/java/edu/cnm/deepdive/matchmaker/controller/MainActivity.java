package edu.cnm.deepdive.matchmaker.controller;

import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;
import edu.cnm.deepdive.matchmaker.R;
import edu.cnm.deepdive.matchmaker.service.FragmentService;

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

}
