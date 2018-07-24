package com.silicon.tareq.spash_scr;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
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

        //next Activity
       final Intent intent=new Intent(this,FirstActivity.class);

        new Handler().postDelayed(new Runnable() { //we are using handler as thread sleep will block ui response
            @Override
            public void run() {

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    startActivity(intent,
                            ActivityOptions.makeSceneTransitionAnimation(SplashActivity.this).toBundle());
                }
            }
        }, 3500); //3.5 sec loading time fake


    }




    }
