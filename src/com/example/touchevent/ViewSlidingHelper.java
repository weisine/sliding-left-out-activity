package com.example.touchevent;

import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.Window;
import android.view.animation.DecelerateInterpolator;

public class ViewSlidingHelper {
    private View decorView;
    private float rawX;
    private float rawY;
    private boolean sliding = false;
    private boolean first = false;
    private int slop;
    private int factor;
    private int width;
    private ViewSlidingListener listener;

    public ViewSlidingHelper(View view, ViewSlidingListener listener, int factor) {
        // TODO Auto-generated constructor stub
        ViewConfiguration vc = ViewConfiguration
                .get(view.getContext());
        slop = vc.getScaledTouchSlop();
        decorView = view;
        this.factor = factor;
        width = view.getWidth();
        this.listener = listener;
    }

    public boolean dispatchTouchEvent(MotionEvent ev) {
        String type = "dispatchTouchEvent";
        String event = "";
        boolean rtn = false;
        switch (ev.getAction()) {
            case MotionEvent.ACTION_MOVE:
                event = "ACTION_MOVE";
                float x = ev.getRawX() - rawX;
                float y = ev.getRawY() - rawY;

                if (first) {
                    if (Math.abs(x) > Math.abs(y) && x > slop) {
                        sliding = true;
                    }
                    System.err.println("setSliding:" + sliding);
                    first = false;
                }
                System.err.println("sliding:" + sliding);
                if (sliding) {
                    decorView.scrollTo(-(int) x, 0);
// if (sliding) {
// ViewHelper.setTranslationX(decorView, x);
// } else if (ViewHelper.getTranslationX(decorView) != 0) {
// ViewHelper.setTranslationX(decorView, 0);
// rawX = ev.getRawX();
// rawY = ev.getRawY();
// }
                    return true;
                }
                break;
            case MotionEvent.ACTION_DOWN:
                rawX = ev.getRawX();
                rawY = ev.getRawY();
                sliding = false;
                first = true;
                event = "ACTION_DOWN";
                Log.e("Activity", "ACTION_DOWN");
                break;
            case MotionEvent.ACTION_CANCEL:
                event = "ACTION_CANCEL";
                break;
            case MotionEvent.ACTION_UP:
                if (sliding) {
                    float x1 = ev.getRawX() - rawX;
                    moveSlow(x1 > factor, (int) x1);
                }
                event = "ACTION_UP";
                break;
            default:
                break;
        }
        rtn = false;
        Log.i("Activity", "type:" + type + "=====event:" + event + "===========" + rtn);
        return false;
    }

    private void moveSlow(final boolean done, int x) {
        int from = x;
        int to = done ? width : 0;
        ValueAnimator animator = ValueAnimator.ofInt(from, to);
        animator.setInterpolator(new DecelerateInterpolator());
        animator.setDuration(500);
        animator.addListener(new AnimatorListener() {

            @Override
            public void onAnimationStart(android.animation.Animator animation) {

            }

            @Override
            public void onAnimationRepeat(android.animation.Animator animation) {

            }

            @Override
            public void onAnimationEnd(android.animation.Animator animation) {
                if (done)
                    listener.onDone();
                else
                    listener.onCancel();
            }

            @Override
            public void onAnimationCancel(android.animation.Animator animation) {

            }
        });

        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int deltaX = (Integer) valueAnimator.getAnimatedValue();
                decorView.scrollTo(-deltaX, 0);
            }
        });
        animator.start();
    }

    public static interface ViewSlidingListener {

        public void onDone();

        public void onCancel();
    }
}
