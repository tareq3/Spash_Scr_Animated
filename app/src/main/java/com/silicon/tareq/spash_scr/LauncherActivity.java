/*
 * Created by Tareq Islam on 7/25/18 5:27 PM
 *
 *  Last modified 7/25/18 4:57 PM
 */

/*
 * Created by Tareq Islam on 7/25/18 4:55 PM
 *
 *  Last modified 7/25/18 4:55 PM
 */

package com.silicon.tareq.spash_scr;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/***
 * Created by Tareq on 25,July,2018.
 */

//Please change the color from color resource
public class LauncherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Todo!:1st way easy one:  Start Activity
        /*From launcher we can even start MainActivity without any transiction anim*/
       // startActivity(new Intent(this,MainActivity.class));
       // finish();

        //Todo: 2nd way reomended one: Using a Launcher_Extender Activity that extends launcer icon preiod with anim transiction
        startActivity(new Intent(this,Launcher_Extender.class));
        finish();
    }
}
