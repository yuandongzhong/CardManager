package co.bankoo.patrick.cardmanager;

import android.app.ActionBar;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        actionBarSetup();
    }

    /**
     * Sets customized Action Bar
     */

    private void actionBarSetup() {
        getSupportActionBar().setTitle("广州XXX科技有限公司");
        getSupportActionBar().setSubtitle("商户管理员");
    }
}
