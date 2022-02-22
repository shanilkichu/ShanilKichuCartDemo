package com.myapp.shanilkichu.Fragmnets;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.myapp.shanilkichu.Adapter.MainCategory_Adapter;
import com.myapp.shanilkichu.Adapter.MyHomepage_Adapter;
import com.myapp.shanilkichu.Helper.VerticalViewPager;
import com.myapp.shanilkichu.R;

import java.util.ArrayList;
import java.util.List;

public class Fragment_HomePage extends Fragment {

    Context context;
    TabLayout tabLayout;
    VerticalViewPager viewPager;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context=getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_homepage, container, false);

        initView(view);
        return view;
    }

    private void initView(View view) {
        tabLayout = view.findViewById(R.id.tabLayout);
        viewPager = view.findViewById(R.id.viewPager);
        tabLayout.addTab(tabLayout.newTab().setText("HEAD TIL 1"));
        tabLayout.addTab(tabLayout.newTab().setText("HEAD TIL 2"));
        tabLayout.addTab(tabLayout.newTab().setText("HEAD TIL 3"));
        tabLayout.addTab(tabLayout.newTab().setText("HEAD TIL 4"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        MyHomepage_Adapter adapter = new MyHomepage_Adapter(getActivity(),getChildFragmentManager(),
                tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }
            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });



    }


}
