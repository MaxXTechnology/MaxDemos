package com.maxtech.maxdemos.anim;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.Button;

import com.maxtech.maxdemos.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AnimationComparison extends AppCompatActivity {

    @BindView(R.id.start_btn)
    Button mButtonStart;
    @BindView(R.id.btn1)
    Button mBtn1;
    @BindView(R.id.btn2)
    Button mBtn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation_comparison);
        ButterKnife.bind(this);
        mButtonStart.setOnClickListener(new View.OnClickListener() {
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
        mBtn1.startAnimation(t);
    }

    public void startBtn2Animator() {
        ObjectAnimator animator = ObjectAnimator.ofFloat(mBtn2, "x", 0, 800);
        animator.setDuration(5000);
        animator.start();
    }

}
