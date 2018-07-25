package com.silicon.tareq.spash_scr;

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
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

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
     // set an exit transition
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setExitTransition(new AutoTransition());
        }
        setContentView(R.layout.activity_splash);

        //Shimmer effect for text
        ShimmerLayout shimmerText = (ShimmerLayout) findViewById(R.id.shimmer_text);
        shimmerText.startShimmerAnimation();

        //todo: initial transition animation
        l1=(ConstraintLayout) findViewById(R.id.top_part);
        upToDown= AnimationUtils.loadAnimation(this,R.anim.uptodown);
        l1.setAnimation(upToDown);

        l2=(ConstraintLayout) findViewById(R.id.bottom_part);
        downToUP=AnimationUtils.loadAnimation(this, R.anim.downtoup);
        l2.setAnimation(downToUP);


        //Intro Activity which will be played only single time on a device
        final Intent intentIntro=new Intent(this,IntroActivity.class);

        //First Activity
       final Intent intentFirst=new Intent(this,FirstActivity.class);


       //Shared pref for storing data for AppLifeTime
       final SharedPreferences sharedPreferences =    PreferenceManager.getDefaultSharedPreferences(this);


       //Making a some second delay call so that splash screen can be showed properly
        new Handler().postDelayed(new Runnable() { //we are using handler as thread sleep will block ui response
            @Override
            public void run() {

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {


                    // Check if we need to display our OnboardingFragment
                    if (!sharedPreferences.getBoolean(
                            "virgin", false)) {
                        // The user hasn't seen the OnboardingFragment yet, so show it
                        startActivity(intentIntro,
                                ActivityOptions.makeSceneTransitionAnimation(SplashActivity.this).toBundle());
                    }else {

                        startActivity(intentFirst,
                                ActivityOptions.makeSceneTransitionAnimation(SplashActivity.this).toBundle());
                    }
                }
            }
        }, 3500); //3.5 sec loading time fake


    }




    }
