package com.maxtech.maxdemos.anim;

import android.app.Activity;
import android.os.Bundle;
import android.support.animation.DynamicAnimation;
import android.support.animation.SpringAnimation;
import android.support.animation.SpringForce;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.maxtech.maxdemos.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by mr on 2017/4/12.
 */

public class SpringAnimationDemo extends Activity {

    @BindView(R.id.container)
    ViewGroup mContainer;

    @BindView(R.id.btn0)
    Button mBtn0;

    @BindView(R.id.btn1)
    Button mBtn1;

    @BindView(R.id.btn2)
    Button mBtn2;

    private GestureDetector mGestureDetector;

    private SpringAnimation mAnimX0;
    private SpringAnimation mAnimY0;
    private SpringAnimation mAnimX1;
    private SpringAnimation mAnimY1;
    private SpringAnimation mAnimX2;
    private SpringAnimation mAnimY2;

    private boolean mIsDrag;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anim_spring);
        ButterKnife.bind(this);

        mGestureDetector = new GestureDetector(this, new MyGesture());
        //0
        mAnimX0 = new SpringAnimation(mBtn0, DynamicAnimation.X);
        mAnimY0 = new SpringAnimation(mBtn0, DynamicAnimation.Y);
        mAnimX0.setSpring(new SpringForce().setStiffness(SpringForce.STIFFNESS_LOW));
        mAnimY0.setSpring(new SpringForce().setStiffness(SpringForce.STIFFNESS_LOW));
        //1
        mAnimX1 = new SpringAnimation(mBtn1, DynamicAnimation.X);
        mAnimY1 = new SpringAnimation(mBtn1, DynamicAnimation.Y);
        mAnimX1.setSpring(new SpringForce().setStiffness(SpringForce.STIFFNESS_LOW));
        mAnimY1.setSpring(new SpringForce().setStiffness(SpringForce.STIFFNESS_LOW));
        //2
        mAnimX2 = new SpringAnimation(mBtn2, DynamicAnimation.X);
        mAnimY2 = new SpringAnimation(mBtn2, DynamicAnimation.Y);
        mAnimX2.setSpring(new SpringForce().setStiffness(SpringForce.STIFFNESS_LOW));
        mAnimY2.setSpring(new SpringForce().setStiffness(SpringForce.STIFFNESS_LOW));

        mBtn0.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    int finalX = (mContainer.getWidth() - mBtn0.getWidth()) / 2;
                    int finalY = mContainer.getHeight() / 2 - mBtn0.getHeight();

                    mAnimX0.animateToFinalPosition(finalX);
                    mAnimY0.animateToFinalPosition(finalY);

                    mAnimX1.animateToFinalPosition(finalX);
                    mAnimY1.animateToFinalPosition(finalY + mBtn0.getHeight());

                    mAnimX2.animateToFinalPosition(finalX);
                    mAnimY2.animateToFinalPosition(finalY + mBtn0.getHeight() + mBtn1.getHeight());
                }
                return mGestureDetector.onTouchEvent(event);
            }
        });

    }

    private class MyGesture implements GestureDetector.OnGestureListener {

        @Override
        public boolean onDown(MotionEvent e) {
            Log.d("okry", "onDown");
            return false;
        }

        @Override
        public void onShowPress(MotionEvent e) {

        }

        @Override
        public boolean onSingleTapUp(MotionEvent e) {
            return false;
        }

        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
            Log.d("okry", "e1:" + e1.getX() + "|" + e1.getAction() + ", e2:" + e2.getX() + "|" + e2.getPointerCount());
            mBtn0.setX(e2.getRawX() - mBtn0.getWidth() / 2);
            mBtn0.setY(e2.getRawY() - mBtn0.getHeight() / 2);
            mAnimX1.animateToFinalPosition(mBtn0.getX());
            mAnimY1.animateToFinalPosition(mBtn0.getY() + mBtn0.getHeight());

            mAnimX2.animateToFinalPosition(mBtn1.getX());
            mAnimY2.animateToFinalPosition(mBtn1.getY() + mBtn1.getHeight());

            return true;
        }

        @Override
        public void onLongPress(MotionEvent e) {
            Log.d("okry", "onLongPress");
        }

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            Log.d("okry", "onFling, velocityX:" + velocityX + ", velocityY:" + velocityY);
            return true;
        }

    }

}
