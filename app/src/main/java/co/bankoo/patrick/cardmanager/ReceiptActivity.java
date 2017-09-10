package co.bankoo.patrick.cardmanager;

import android.app.Activity;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import static java.security.AccessController.getContext;

public class ReceiptActivity extends AppCompatActivity {

    EditText editText;
    Button sendButton;          // Button for submitting
    TextView barTitle;

    String activityTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receipt);

        activityTitle = "收款";

        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null) {
            actionBar.hide();               // Remove the default Action Bar
        }

        barTitle = (TextView) findViewById(R.id.title_text);
        barTitle.setText(activityTitle);

        editText = (EditText) findViewById(R.id.receipt_amount);
        editText.addTextChangedListener(new DecimalFilter(editText, this));     // Limit the decimal digits to 2

        sendButton = (Button) findViewById(R.id.button_receipt);


    }
}
