package com.silicon.tareq.spash_scr;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.AutoTransition;
import android.transition.Fade;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import io.supercharge.shimmerlayout.ShimmerLayout;

//Branch_01
public class SplashActivity extends AppCompatActivity {


    private final int interval=3000; //2sec
    private  Launcher mLauncher = new Launcher();;
    private Handler mHandler= new Handler(); //for Sleep Thread alternative

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
        l1=(ConstraintLayout) findViewById(R.id.top_part);
        upToDown= AnimationUtils.loadAnimation(this,R.anim.uptodown);
        l1.setAnimation(upToDown);

        l2=(ConstraintLayout) findViewById(R.id.bottom_part);
        downToUP=AnimationUtils.loadAnimation(this, R.anim.downtoup);
        l2.setAnimation(downToUP);



    }

    @Override
    protected void onStart() {
        super.onStart();
        mHandler.postDelayed(mLauncher, interval); //Starting Thread
    }

    @Override
    protected void onStop() {
        mHandler.removeCallbacks(mLauncher); //For sudden stop removing the call back
        super.onStop();
    }

    private void launch() {
        if(!isFinishing()){
            startActivity(new Intent(this, FirstActivity.class));
            overridePendingTransition(R.anim.fade_in,R.anim.fade_out); //after starting activity we need to set the transition anim
            finish();
        }
    }

    private class Launcher implements Runnable{

        @Override
        public void run() {
            launch();
        }


    }


    }
