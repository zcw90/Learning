package com.zcw.taskdemo;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.zcw.base.CommonUtils;
import com.zcw.taskdemo.util.Util;

public class ViewActivity extends Activity implements View.OnClickListener {
    private static final String TAG = ViewActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        init();
    }

    private void init() {
        findViewById(R.id.cl_view_root).setOnClickListener(this);
        findViewById(R.id.my_view1).setOnClickListener(this);
        findViewById(R.id.my_view2).setOnClickListener(this);
        findViewById(R.id.my_view_group1).setOnClickListener(this);
        findViewById(R.id.my_view_group2).setOnClickListener(this);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.e(TAG, "dispatchTouchEvent - " + Util.getEvent(ev.getAction()));
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e(TAG, "onTouchEvent - " + Util.getEvent(event.getAction()));
        return super.onTouchEvent(event);
    }

    @Override
    public void onClick(View v) {
        CommonUtils.toast(ViewActivity.this, "View: " + Util.viewLevel(v));
        switch (v.getId()) {
            case R.id.cl_view_root:
                break;

            case R.id.my_view1:
                break;

            case R.id.my_view2:
                break;

            case R.id.my_view_group1:
                break;

            case R.id.my_view_group2:
                break;
        }
    }
}
