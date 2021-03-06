package com.example.touchevent;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.ListView;

public class TouchListView extends ListView {
    private final String tag = getClass().getSimpleName();

    public TouchListView(Context context) {
        super(context);
        // TODO Auto-generated constructor stub
    }

    public TouchListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        // TODO Auto-generated constructor stub
    }

    public TouchListView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        // TODO Auto-generated constructor stub
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        // TODO Auto-generated method stub
        String type = "dispatchTouchEvent";
        String event = "";
        boolean rtn = false;
        switch (ev.getAction()) {
            case MotionEvent.ACTION_MOVE:
                event = "ACTION_MOVE";
                break;
            case MotionEvent.ACTION_DOWN:
                event = "ACTION_DOWN";
                break;
            case MotionEvent.ACTION_CANCEL:
                event = "ACTION_CANCEL";
                break;
            case MotionEvent.ACTION_UP:
                event = "ACTION_UP";
                break;
            default:
                break;
        }
        rtn = super.dispatchTouchEvent(ev);
        Log.i(tag, "type:" + type + "=====event:" + event + "===========" + rtn);
        return rtn;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        // TODO Auto-generated method stub
        String type = "onInterceptTouchEvent";
        String event = "";
        boolean rtn = false;
        switch (ev.getAction()) {
            case MotionEvent.ACTION_MOVE:
                event = "ACTION_MOVE";
                break;
            case MotionEvent.ACTION_DOWN:
                event = "ACTION_DOWN";
                break;
            case MotionEvent.ACTION_CANCEL:
                event = "ACTION_CANCEL";
                break;
            case MotionEvent.ACTION_UP:
                event = "ACTION_UP";
                break;
            default:
                break;
        }
        rtn = super.onInterceptHoverEvent(ev);
        Log.i(tag, "type:" + type + "=====event:" + event + "===========" + rtn);
        return rtn;
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        // TODO Auto-generated method stub
        String type = "onTouchEvent";
        String event = "";
        boolean rtn = false;
        switch (ev.getAction()) {
            case MotionEvent.ACTION_MOVE:
                event = "ACTION_MOVE";
                break;
            case MotionEvent.ACTION_DOWN:
                event = "ACTION_DOWN";
                break;
            case MotionEvent.ACTION_CANCEL:
                event = "ACTION_CANCEL";
                break;
            case MotionEvent.ACTION_UP:
                event = "ACTION_UP";
                break;
            default:
                break;
        }
        rtn = super.onTouchEvent(ev);
        Log.i(tag, "type:" + type + "=====event:" + event + "===========" + rtn);
        return rtn;
    }
}
