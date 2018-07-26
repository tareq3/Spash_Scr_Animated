package com.silicon.tareq.spash_scr.Launcher_Splash.IntoActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.github.paolorotolo.appintro.AppIntro;
import com.github.paolorotolo.appintro.AppIntroFragment;
import com.silicon.tareq.spash_scr.MainActivity;
import com.silicon.tareq.spash_scr.R;

/***
 * Created by Tareq on 25,July,2018.
 */
public class IntroActivity extends AppIntro {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Note here that we DO NOT use setContentView();

        // Add your slide fragments here.
        // AppIntro will automatically generate the dots indicator and buttons

        /*  Here is more than 3 way of creating Slide
            *1. Using custom Fragment
            *2. Using   SampleSlideClass and custom xml
            *3. Using Default AppIntroFragment */


       // addSlide(SampleSlide.newInstance(R.layout.slide_1));

            addSlide(AppIntroFragment.newInstance("Notification","I can set notification for you.",R.drawable.androidnotification,getResources().getColor(R.color.slide_bg_1)));
            addSlide(AppIntroFragment.newInstance("Alarm","I can set alarm for you ",R.drawable.alarm_slide2,getResources().getColor(R.color.slide_bg_2)));
            addSlide(AppIntroFragment.newInstance( "Notification And alarm slide", "I can set both by a Single tap.",R.drawable.ic_done_white,getResources().getColor(R.color.slide_bg_3)));



/*
        // Hide Skip/Done button.
        showSkipButton(false);
        setProgressButtonEnabled(false);*/

    }


    @Override
    public void onSkipPressed(Fragment currentFragment) {
        super.onSkipPressed(currentFragment);
        // Do something when users tap on Skip button.
    }

    @Override
    public void onDonePressed(Fragment currentFragment) {
        super.onDonePressed(currentFragment);

        //Todo!1: Change pref value to true so it doesn't play again
       SharedPreferences.Editor sharedPreferencesEditor =
                PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).edit();
        sharedPreferencesEditor.putBoolean("virgin", true);
        sharedPreferencesEditor.apply();

        //Todo!2: start First Activity
        //First Activity
            Intent intentFirst=new Intent(this,MainActivity.class);
            startActivity(intentFirst);
            finish();

    }

    @Override
    public void onSlideChanged(@Nullable Fragment oldFragment, @Nullable Fragment newFragment) {
        super.onSlideChanged(oldFragment, newFragment);
        // Do something when the slide changes.
    }
}
