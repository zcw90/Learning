package com.zcw.taskdemo;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.os.Handler;
import android.os.Message;

import java.lang.ref.WeakReference;

public class LauncherActivity extends Activity {

    private LauncherHandler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_launcher);

        handler = new LauncherHandler(this);
        handler.sendEmptyMessageDelayed(LauncherHandler.TO_MAIN_PAGE, 2000);
    }

    private static class LauncherHandler extends Handler {
        public static final int TO_MAIN_PAGE = 10;

        private WeakReference<Activity> activity;

        public LauncherHandler(Activity activity) {
            this.activity = new WeakReference<>(activity);
        }

        @Override
        public void handleMessage(Message msg) {
            if(msg.what == TO_MAIN_PAGE) {
                Intent intent = new Intent(activity.get(), MainActivity.class);
                activity.get().startActivity(intent);
                activity.get().finish();
                return ;
            }

            super.handleMessage(msg);
        }
    }
}
