package co.bankoo.patrick.cardmanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import co.bankoo.patrick.cardmanager.Controllers.BaseActivity;

public class ChangeCardActivity extends BaseActivity {

    String activityTitle;
    TextView barTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_card);

        activityTitle = "换卡";
        barTitle = (TextView) findViewById(R.id.title_text);
        barTitle.setText(activityTitle);




    }
}
