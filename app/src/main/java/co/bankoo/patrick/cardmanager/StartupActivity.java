package co.bankoo.patrick.cardmanager;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import co.bankoo.patrick.cardmanager.Controllers.BaseActivity;

public class StartupActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startup);

        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent it = new Intent(StartupActivity.this, MainActivity.class);
                startActivity(it);
                StartupActivity.this.finish();
            }
        }, 2*1000);
    }

    Handler mHandler = new Handler();
}
