package com.silicon.tareq.spash_scr;

import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

//Branch_01
public class MainActivity extends AppCompatActivity {


    ConstraintLayout l1,l2;

    Animation upToDown,downToUP;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //todo: Write the codes below
        l1=(ConstraintLayout) findViewById(R.id.top_part);
        upToDown= AnimationUtils.loadAnimation(this,R.anim.uptodown);
        l1.setAnimation(upToDown);

        l2=(ConstraintLayout) findViewById(R.id.bottom_part);
        downToUP=AnimationUtils.loadAnimation(this, R.anim.downtoup);
        l2.setAnimation(downToUP);


    }




    private void tag(){

    }
}
