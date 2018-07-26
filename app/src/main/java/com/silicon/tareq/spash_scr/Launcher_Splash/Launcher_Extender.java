/*
 * Created by Tareq Islam on 7/25/18 3:06 PM
 *
 *  Last modified 7/25/18 3:06 PM
 */

package com.silicon.tareq.spash_scr.Launcher_Splash;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.silicon.tareq.spash_scr.Launcher_Splash.IntoActivity.IntroActivity;
import com.silicon.tareq.spash_scr.MainActivity;
import com.silicon.tareq.spash_scr.R;

/***
 * Created by Tareq on 25,July,2018.
 */
public class Launcher_Extender extends AppCompatActivity {

    //This activity extends launcher icon preiod it just show the same layout as laucher has


    private static final int LAUNCHER_PREIOD = 2000; //2 sec

    private final Handler mHandler   = new Handler();
    private final Launcher mLauncher = new Launcher();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        // Make sure this is before calling super.onCreate
        setTheme(R.style.Launcher);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.launcher_ext_layout);



    }


    @Override
    protected void onStart() {
        super.onStart();

        mHandler.postDelayed(mLauncher, LAUNCHER_PREIOD);
    }

    @Override
    protected void onStop() {
        mHandler.removeCallbacks(mLauncher);
        super.onStop();
    }

    private void launch() {
        if (!isFinishing()) {

            //Shared pref for storing data for AppLifeTime
            final SharedPreferences sharedPreferences =    PreferenceManager.getDefaultSharedPreferences(this);

            // Check if we need to display our OnboardingFragment
            if (!sharedPreferences.getBoolean(
                    "virgin", false)) {

                startActivity(new Intent(this, IntroActivity.class)); //Here set the next activity
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();

            }else {

                startActivity(new Intent(this, MainActivity.class)); //Here set the next activity
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();
            }

        }
    }

    private class Launcher implements Runnable {
        @Override
        public void run() {
            launch();
        }
    }
}
