package com.myapp.shanilkichu.View;

import android.app.Activity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.tabs.TabLayout;
import com.myapp.shanilkichu.Adapter.MyHomepage_Adapter;
import com.myapp.shanilkichu.Fragmnets.Fragment_HomePage;
import com.myapp.shanilkichu.R;
import com.myapp.shanilkichu.databinding.LayoutHomeBinding;

public class Activity_Home extends AppCompatActivity {

    LayoutHomeBinding binding;
    Activity activity=this;

    private Fragment fragment;
    private FragmentManager fragmentManager;
    FragmentTransaction transaction;

    private static final int TIME_DELAY = 2000;
    private static long back_pressed;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        binding= LayoutHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initFunctions();

    }

    private void initFunctions() {

        fragmentManager = getSupportFragmentManager();
        transaction = fragmentManager.beginTransaction();
        fragment = new Fragment_HomePage();
        transaction.add(R.id.main_container, fragment).commit();


    }

    @Override
    public void onBackPressed() {
        if (back_pressed + TIME_DELAY > System.currentTimeMillis()) {
            super.onBackPressed();
        } else {
            Toast.makeText(getApplicationContext(), "Press once again to exit!", Toast.LENGTH_SHORT).show();
        }
        back_pressed = System.currentTimeMillis();
    }


}
