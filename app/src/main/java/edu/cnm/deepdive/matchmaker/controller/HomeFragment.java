package edu.cnm.deepdive.matchmaker.controller;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import edu.cnm.deepdive.matchmaker.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {


  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    return inflater.inflate(R.layout.fragment_home, container, false);
  }

  public void switchToHomeFragment(){
    FragmentManager manager = getFragmentManager();
    manager.beginTransaction().replace(R.id.fragment_home, new HomeFragment()).commit();
  }

}
