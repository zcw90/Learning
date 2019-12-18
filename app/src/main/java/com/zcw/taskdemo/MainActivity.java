package com.zcw.taskdemo;

import android.app.ActivityManager;
import android.app.usage.UsageStats;
import android.app.usage.UsageStatsManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.StrictMode;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextPaint;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = MainActivity.class.getSimpleName();

    private Button btnTest;
    private WindowManager.LayoutParams layoutParams;
    private WindowManager windowManager;

    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        strictMode();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void strictMode() {
        if (BuildConfig.DEBUG) {
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
                    .detectDiskReads()
                    .detectDiskWrites()
                    .detectNetwork()
                    .build());

            StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
                    .detectLeakedSqlLiteObjects()
                    .detectLeakedClosableObjects()
                    .penaltyLog()
                    .penaltyDeath()
                    .build());
        }
    }

    private void init() {
        windowManager = (WindowManager) getSystemService(Context.WINDOW_SERVICE);

        findViewById(R.id.btn_add_button).setOnClickListener(this);
        findViewById(R.id.btn_rx_java_test).setOnClickListener(this);
        findViewById(R.id.btn_frame_layout).setOnClickListener(this);
        findViewById(R.id.btn_activity_manager).setOnClickListener(this);
        findViewById(R.id.btn_view).setOnClickListener(this);
        editText = findViewById(R.id.editText);

        final int textPadding = (int) getResources().getDimension(R.dimen.dp_10);
        editText.post(new Runnable() {
            @Override
            public void run() {

                TextPaint paint = editText.getPaint();
                Paint.FontMetrics fm = new Paint.FontMetrics();
                int textHeight = (int) paint.getFontMetrics(fm);
                Drawable drawableLeft = getResources().getDrawable(R.mipmap.ic_launcher);
//                drawableLeft.setBounds(0, 0, editText.getHeight(), editText.getHeight());
                drawableLeft.setBounds(0, 0, textHeight - textPadding, textHeight - textPadding);

                Drawable drawableRight = getResources().getDrawable(R.mipmap.addfriend_on);
//                drawableRight.setBounds(0, 0, editText.getHeight(), editText.getHeight());
                drawableRight.setBounds(0, 0, textHeight - textPadding, textHeight - textPadding);
                editText.setCompoundDrawables(drawableLeft, null, drawableRight, null);
            }
        });
    }

    private void addButton() {
        btnTest = new Button(this);
        btnTest.setOnTouchListener(touchListener);
        btnTest.setText("Button");
        layoutParams = new WindowManager.LayoutParams(
                WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT, 0, 0, PixelFormat.TRANSPARENT);
        layoutParams.flags = WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL | WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE |
                WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED;
        layoutParams.type = WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY;
        layoutParams.gravity = Gravity.LEFT | Gravity.TOP;
        layoutParams.x = 100;
        layoutParams.y = 400;
        windowManager.addView(btnTest, layoutParams);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.btn_add_button:
                addButton();
                Toast.makeText(MainActivity.this.getApplicationContext(), "Toast", Toast.LENGTH_SHORT).show();
                break;

            case R.id.btn_rx_java_test:
                intent = new Intent(MainActivity.this, RxJavaActivity.class);
                startActivity(intent);
                break;

            case R.id.btn_frame_layout:
                intent = new Intent(MainActivity.this, FrameActivity.class);
                startActivity(intent);
                break;

            case R.id.btn_activity_manager:
                getAppTask2();
                break;

            case R.id.btn_view:
                throw new UnsupportedOperationException("Use StringFactory instead.");
//                intent = new Intent(MainActivity.this, ViewActivity.class);
//                startActivity(intent);
//
//                try {
//                    String s = new String("ABC");
//                    System.out.println(s);
//                }
//                catch (UnsupportedOperationException e) {
//                    e.printStackTrace();
//                    break;
//                }
//                break;
        }
    }

    private View.OnTouchListener touchListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            float rawX = event.getRawX();
            float rawY = event.getRawY();
            switch (event.getAction()) {
                case MotionEvent.ACTION_MOVE:
                    layoutParams.x = (int) rawX;
                    layoutParams.y = (int) rawY;
                    windowManager.updateViewLayout(btnTest, layoutParams);
                    break;
            }
            return false;
        }
    };

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        Log.e("zcw", "time: " + System.currentTimeMillis());
        return super.dispatchKeyEvent(event);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void getAppTask2() {
        UsageStatsManager manager = (UsageStatsManager) getSystemService(Context.USAGE_STATS_SERVICE);
        if (manager != null) {
            long start = System.currentTimeMillis();
            List<UsageStats> list = manager.queryUsageStats(UsageStatsManager.INTERVAL_BEST, start - 1000 * 60 * 10, start);
            for (UsageStats stats : list) {
                Log.e(TAG, "App Info: " + stats.getPackageName());
            }
        }
    }
}
