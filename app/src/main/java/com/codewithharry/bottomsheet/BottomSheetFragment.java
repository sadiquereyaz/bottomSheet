package com.codewithharry.bottomsheet;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.android.material.tabs.TabLayout;

public class BottomSheetFragment extends BottomSheetDialogFragment {

    public BottomSheetFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_bottom_sheet, container, false);

        ViewPager viewPager = rootView.findViewById(R.id.view_pager_bottom_sheet);
        TabLayout tabLayout = rootView.findViewById(R.id.bottom_sheet_tablayout);

        TabAdapter tabAdapter = new TabAdapter(getChildFragmentManager());
        tabAdapter.addFragment(new NotesTabFragment(), "Notes");
        tabAdapter.addFragment(new PyqTabFragment(), "PYQ");
        tabAdapter.addFragment(new PlaylistTabFragment(), "Playlist");

        // Set the adapter for the ViewPager
        viewPager.setAdapter(tabAdapter);

        // Connect the TabLayout with the ViewPager
        tabLayout.setupWithViewPager(viewPager);


        return rootView;
    }
}