package com.example.touchevent;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

public class MainActivity extends Activity {

    private ViewSlidingHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TouchListView listView = (TouchListView) findViewById(R.id.content3);
        listView.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, new String[] {
                "List Touch Event", "List Touch Event", "List Touch Event", "List Touch Event",
                "List Touch Event", "List Touch Event", "List Touch Event", "List Touch Event",
                "List Touch Event", "List Touch Event", "List Touch Event", "List Touch Event",
                "List Touch Event", "List Touch Event", "List Touch Event", "List Touch Event",
                "List Touch Event", "List Touch Event", "List Touch Event", "List Touch Event",
                "List Touch Event", "List Touch Event", "List Touch Event", "List Touch Event",
                "List Touch Event", "List Touch Event", "List Touch Event", "List Touch Event",
                "List Touch Event", "List Touch Event", "List Touch Event"
        }));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                // TODO Auto-generated method stub
                System.err.println("itemclick");
            }
        });
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        // TODO Auto-generated method stub
        String type = "Activity";
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
        Log.i("Activity", "type:" + type + "=====event:" + event + "===========" + rtn);
        return rtn;
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        // TODO Auto-generated method stub
// String type = "dispatchTouchEvent";
// String event = "";
// boolean rtn = false;
// switch (ev.getAction()) {
// case MotionEvent.ACTION_MOVE:
// event = "ACTION_MOVE";
// float x = ev.getRawX() - rawX;
// float y = ev.getRawY() - rawY;
//
// if (first) {
// if (Math.abs(x) > Math.abs(y) && x > slop) {
// sliding = true;
// }
// System.err.println("setSliding:" + sliding);
// first = false;
// }
// System.err.println("sliding:" + sliding);
// if (sliding) {
// // if (sliding) {
// ViewHelper.setTranslationX(decorView, x);
// // } else if (ViewHelper.getTranslationX(decorView) != 0) {
// // ViewHelper.setTranslationX(decorView, 0);
// // rawX = ev.getRawX();
// // rawY = ev.getRawY();
// // }
// return true;
// }
// break;
// case MotionEvent.ACTION_DOWN:
// rawX = ev.getRawX();
// rawY = ev.getRawY();
// sliding = false;
// first = true;
// event = "ACTION_DOWN";
// Log.e("Activity", "ACTION_DOWN");
// break;
// case MotionEvent.ACTION_CANCEL:
// event = "ACTION_CANCEL";
// break;
// case MotionEvent.ACTION_UP:
// ViewHelper.setTranslationX(decorView, 0);
// event = "ACTION_UP";
// break;
// default:
// break;
// }
// rtn = super.dispatchTouchEvent(ev);
// Log.i("Activity", "type:" + type + "=====event:" + event + "===========" + rtn);
        if(helper == null){
            helper = new ViewSlidingHelper(getWindow().getDecorView(),
                    new ViewSlidingHelper.ViewSlidingListener() {

                        @Override
                        public void onDone() {
                            // TODO Auto-generated method stub
                            finish();
                        }

                        @Override
                        public void onCancel() {
                            // TODO Auto-generated method stub

                        }
                    }, 200);
        }
        if(helper.dispatchTouchEvent(ev)){
            return true;
        }
        return super.dispatchTouchEvent(ev);
    }

}
