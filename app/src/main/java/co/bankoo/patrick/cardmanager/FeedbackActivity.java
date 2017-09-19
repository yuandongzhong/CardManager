package co.bankoo.patrick.cardmanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class FeedbackActivity extends AppCompatActivity {

    String activityTitle;
    TextView barTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        activityTitle = "用户反馈";
        barTitle = (TextView) findViewById(R.id.title_text);
        barTitle.setText(activityTitle);
    }
}
