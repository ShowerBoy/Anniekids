package com.annie.annieforchild.ui.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import com.annie.annieforchild.R;
import com.annie.annieforchild.base.BaseActivity;
import com.annie.annieforchild.ui.activity.login.LoginActivity;

import java.util.Timer;
import java.util.TimerTask;

import cn.droidlover.xdroidmvp.router.Router;

public class GuideActivity extends BaseActivity {
    private TimerTask task;
    private Timer timer;
    private Handler handler;

    @Override
    public void initData(Bundle savedInstanceState) {
        timer = new Timer();
        task = new TimerTask() {
            @Override
            public void run() {
                handler = new Handler(Looper.getMainLooper());
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        Router.newIntent(GuideActivity.this).to(LoginActivity.class).launch();
                        finish();
                    }
                });
            }
        };
        timer.schedule(task, 2 * 1000);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_guide;
    }

    @Override
    public Object newP() {
        return null;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeCallbacksAndMessages(null);
    }
}
