package com.wordpress.zubeentolani.arjayv010;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.LinearLayout;


public class WelcomeActivity extends Activity {

    LinearLayout aboveArjay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        getActionBar().hide();
        aboveArjay = (LinearLayout) findViewById(R.id.LinearLayout_aboveArjay);

        Animation alpha = new AlphaAnimation(0, 1);
        alpha.setDuration(2000);

        aboveArjay.startAnimation(alpha);

        final Intent MainActivity_intent = new Intent(this, Level2BaseActivity.class);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(MainActivity_intent);
            }
        }, 2000);

    }

}
