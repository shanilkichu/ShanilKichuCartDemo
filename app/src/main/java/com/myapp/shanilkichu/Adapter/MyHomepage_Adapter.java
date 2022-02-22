package com.myapp.shanilkichu.Adapter;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.myapp.shanilkichu.Fragmnets.Header1_Fragment;

public class MyHomepage_Adapter extends FragmentPagerAdapter {
    Context context;
    int totalTabs;
    public MyHomepage_Adapter(Context c, FragmentManager fm, int totalTabs) {
        super(fm);
        context = c;
        this.totalTabs = totalTabs;
    }
    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new Header1_Fragment();
            case 1:
                return new Header1_Fragment();
            case 2:
                return new Header1_Fragment();
            case 3:
                return new Header1_Fragment();
            default:
                return null;
        }
    }
    @Override
    public int getCount() {
        return totalTabs;
    }
}