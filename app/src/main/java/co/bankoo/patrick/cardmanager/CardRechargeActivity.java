package co.bankoo.patrick.cardmanager;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import co.bankoo.patrick.cardmanager.Controllers.BaseActivity;

public class CardRechargeActivity extends BaseActivity {

    String activityTitle;
    TextView barTitle;
    View titleBar;
    ImageButton cancelButton;

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


        /*
            WARNING!! -> The cancel button activate the transaction activity for demo purpose!
            TODO:     -> This need to be revised in the later development state.
         */
        cancelButton = (ImageButton) findViewById(R.id.button_cancel_recharge);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CardRechargeActivity.this, TransactionActivity.class);
                intent.putExtra("task_name", activityTitle);
                startActivity(intent);
            }
        });
    }
}
