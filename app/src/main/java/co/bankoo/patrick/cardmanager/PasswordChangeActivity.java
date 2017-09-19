package co.bankoo.patrick.cardmanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class PasswordChangeActivity extends AppCompatActivity {

    String activityTitle;
    TextView barTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password_change);

        activityTitle = "修改密码";
        barTitle = (TextView) findViewById(R.id.title_text);
        barTitle.setText(activityTitle);
    }
}
