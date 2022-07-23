 package com.gizcompony.prototype.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.gizcompony.prototype.R;
import com.gizcompony.prototype.databinding.ActivitySplashBinding;

 public class SplashActivity extends AppCompatActivity {

    ActivitySplashBinding binding ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySplashBinding.inflate(getLayoutInflater());
        getWindow().setStatusBarColor(getResources().getColor(R.color.ultra_light_main_color));
        setContentView(binding.getRoot());


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(getBaseContext() , MainActivity.class));
                finish();
            }
        }, 250);
    }
}