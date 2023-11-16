package com.ramotion.fluidslider.example.simple.java;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.Path;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.ScaleAnimation;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

public class AnimationActivity extends AppCompatActivity {

    View redView;
    View blueView;

    @SuppressWarnings("Convert2Lambda")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.animation_activity_main);

        redView = findViewById(R.id.redView);
        blueView = findViewById(R.id.blueView);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//                    startCirclePathAnimation();
                }

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    jielouAnimation();
                }

//                redRippleAnimation();

//                blueRippleAnimation();

            }
        },5000);

        List<String> originalList = new ArrayList<>();
        originalList.add("1");
        originalList.add("2");
        originalList.add("2");
        originalList.add("1");
        originalList.add("3");

        List<String> value = removeDumplate(originalList);

        Log.d("wutianlong", "removeDumplate22  : " + value);

    }

    private List<String> removeDumplate(List<String> originalList) {

        Set<String> set = new LinkedHashSet<>(originalList); // 使用LinkedHashSet以保留原始顺序

        return new ArrayList<>(set);

     /*   List<String> distinctList = new ArrayList<>();
        Set<String> set = new HashSet<>();

        for (String item : originalList) {
            if (set.add(item)) {
                distinctList.add(item);
            }
        }

        return distinctList;*/
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void jielouAnimation() {
        redView.setVisibility(View.VISIBLE);

        final int width = redView.getMeasuredWidth();
        final int height = redView.getMeasuredHeight();
        final float radius = (float) Math.sqrt(width * width + height * height) / 2;//半径

        Animator animator = ViewAnimationUtils.createCircularReveal(redView, width / 2, height / 2, 0, radius);
        animator.setDuration(800);
        animator.setInterpolator(new AccelerateDecelerateInterpolator());
        animator.start();
    }

    private void redRippleAnimation() {
        redView.setVisibility(View.VISIBLE);

        AnimatorSet animatorSet = new AnimatorSet();

        ObjectAnimator scaleX = ObjectAnimator.ofFloat(redView, "scaleX", 0.0f, 1.0f);
        ObjectAnimator scaleY = ObjectAnimator.ofFloat(redView, "scaleY", 0.0f, 1.0f);
        ObjectAnimator alpha = ObjectAnimator.ofFloat(redView, "alpha", 0.0f, 1.0f);

        animatorSet.playTogether(scaleX, scaleY, alpha);
        animatorSet.setDuration(800);
        animatorSet.setInterpolator(new AccelerateInterpolator());

        animatorSet.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
            }

            @Override
            public void onAnimationEnd(Animator animation) {
//                blueView.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onAnimationCancel(Animator animation) {
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
            }
        });

        animatorSet.start();
    }

    private void blueRippleAnimation() {
        blueView.setVisibility(View.VISIBLE);

        AnimatorSet animatorSet = new AnimatorSet();

//        ObjectAnimator scaleX = ObjectAnimator.ofFloat(redView, "scaleX", 1.0f, 0.0f);
//        ObjectAnimator scaleY = ObjectAnimator.ofFloat(redView, "scaleY", 1.0f, 0.0f);


        ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f,
                ScaleAnimation.RELATIVE_TO_SELF, 0.5f,
                ScaleAnimation.RELATIVE_TO_SELF, 0.5f);


        ObjectAnimator alpha = ObjectAnimator.ofFloat(redView, "alpha", 1.0f, 0.0f);

//        animatorSet.playTogether(scaleX, scaleY, alpha);
        scaleAnimation.setDuration(800);
        scaleAnimation.start();

        animatorSet.setDuration(800);
        animatorSet.setInterpolator(new AccelerateInterpolator());

        animatorSet.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                blueView.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onAnimationCancel(Animator animation) {
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
            }
        });

//        animatorSet.start();
    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void startCirclePathAnimation() {
        redView.setVisibility(View.VISIBLE);

//        float centerX = redView.getX() + redView.getWidth() / 2;
//        float centerY = redView.getY() + redView.getHeight() / 2;
//        float radius = 200;

        float centerX = redView.getX() ;
        float centerY = redView.getY() ;

        float radius = redView.getWidth() / 2;

        Path circlePath = new Path();
        circlePath.addCircle(centerX, centerY, radius, Path.Direction.CW);

        ObjectAnimator pathAnimator = ObjectAnimator.ofFloat(redView, View.X, View.Y, circlePath);


        ObjectAnimator scaleX = ObjectAnimator.ofFloat(redView, "scaleX", 1.0f, 0.0f);
        ObjectAnimator scaleY = ObjectAnimator.ofFloat(redView, "scaleY", 1.0f, 0.0f);
        ObjectAnimator alpha = ObjectAnimator.ofFloat(redView, "alpha", 1.0f, 0.0f);

        pathAnimator.setDuration(800);
        pathAnimator.setInterpolator(new AccelerateInterpolator());

        AnimatorSet animatorSet = new AnimatorSet();

        animatorSet.playTogether(pathAnimator,scaleX,scaleY,alpha);

        animatorSet.start();
    }
}
