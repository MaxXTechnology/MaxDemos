package com.maxtech.maxdemos.anim;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import android.widget.Button;

import com.maxtech.maxdemos.R;

public class AnimationComparison extends AppCompatActivity {

    Button btn1;
    Button btn2;

    ViewGroup container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation_comparison);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        container = (ViewGroup) findViewById(R.id.container);
        findViewById(R.id.start_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startBtn1Animation();
                startBtn2Animator();
            }
        });
    }

    public void startBtn1Animation() {
        TranslateAnimation t = new TranslateAnimation(0, 800, 0, 0);
        t.setDuration(5000);
        btn1.startAnimation(t);
    }

    public void startBtn2Animator() {
        ObjectAnimator animator = ObjectAnimator.ofFloat(btn2, "x", 0, 800);
        animator.setDuration(5000);
        animator.start();
    }

}
