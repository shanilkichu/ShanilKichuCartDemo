package com.myapp.shanilkichu.View;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

import com.myapp.shanilkichu.R;
import com.myapp.shanilkichu.databinding.ActivityMainBinding;

@SuppressLint("CustomSplashScreen")
public class Activity_SplashScreen extends AppCompatActivity {

    Activity activity=this;
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initFunctions();
    }

    private void initFunctions() {

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent in=new Intent(Activity_SplashScreen.this,Activity_Home.class);
                in.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                in.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(in);
                finish();
                overridePendingTransition(R.anim.slide_in_right, R.anim.anim_nothing);

            }
        }, 1000);


    }
}