package com.silicon.tareq.spash_scr.Launcher_Splash;

import android.app.ActivityOptions;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.AutoTransition;
import android.transition.Fade;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;


import com.silicon.tareq.spash_scr.MainActivity;
import com.silicon.tareq.spash_scr.Launcher_Splash.IntoActivity.*;
import com.silicon.tareq.spash_scr.R;

import io.supercharge.shimmerlayout.ShimmerLayout;

//Branch_01
public class SplashActivity extends AppCompatActivity {


    //layout for transition Animation
    ConstraintLayout l1,l2;

    //Custom animation
    Animation upToDown,downToUP;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash);

        //Shimmer effect for text
        ShimmerLayout shimmerText = (ShimmerLayout) findViewById(R.id.shimmer_text);
        shimmerText.startShimmerAnimation();

        //todo: initial transition animation

            l1 = (ConstraintLayout) findViewById(R.id.top_part);
            upToDown = AnimationUtils.loadAnimation(this, R.anim.uptodown);
            l1.setAnimation(upToDown);

            l2 = (ConstraintLayout) findViewById(R.id.bottom_part);
            downToUP = AnimationUtils.loadAnimation(this, R.anim.downtoup);
            l2.setAnimation(downToUP);


        //Intro Activity which will be played only single time on a device
        final Intent intentIntro=new Intent(this,IntroActivity.class);

        //First Activity
       final Intent intentFirst=new Intent(this,MainActivity.class);


       //Shared pref for storing data for AppLifeTime
       final SharedPreferences sharedPreferences =    PreferenceManager.getDefaultSharedPreferences(this);


       //Making a some second delay call so that splash screen can be showed properly
        new Handler().postDelayed(new Runnable() { //we are using handler as thread sleep will block ui response
            @Override
            public void run() {



                    // Check if we need to display our OnboardingFragment
                    if (!sharedPreferences.getBoolean(
                            "virgin", false)) {

                            startActivity(intentIntro);
                                finish();

                    }else {

                            startActivity(intentFirst);
                                finish();
                    }
                }

        }, 3500); //3.5 sec loading time fake


    }




    }
