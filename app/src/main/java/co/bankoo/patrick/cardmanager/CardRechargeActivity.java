package co.bankoo.patrick.cardmanager;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.TextView;

public class CardRechargeActivity extends AppCompatActivity {

    String activityTitle;
    TextView barTitle;
    View titleBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_recharge);

        /*
             Setup the custom Action Bar
         */
        activityTitle = "充值";
        barTitle = (TextView) findViewById(R.id.title_text);
        barTitle.setText(activityTitle);
        titleBar = (View) findViewById(R.id.title_bar);
        titleBar.setBackgroundColor(Color.parseColor("#FEB832"));


    }
}
