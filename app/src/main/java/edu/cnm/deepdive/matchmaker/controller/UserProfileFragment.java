package edu.cnm.deepdive.matchmaker.controller;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import edu.cnm.deepdive.matchmaker.R;

public class UserProfileFragment extends Fragment {

  /**
   * <code>onCreateView</code> inflates the layout associated with the fragment.
   * @param inflater inflates R.layout.fragment_matches
   * @param container refers to the <code>fragment_container</code>
   * @param savedInstanceState saves when the fragment is inflated and selected
   * @return sets the layout to inflate.
   */
@Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    return inflater.inflate(R.layout.fragment_user_profile, container, false);
  }


}
