package co.bankoo.patrick.cardmanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import co.bankoo.patrick.cardmanager.Controllers.DecimalFilter;

public class ReceiptActivity extends AppCompatActivity {

    EditText editText;
    Button confirmButton;          // Button for submitting
    TextView barTitle;

    String activityTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receipt);

        activityTitle = "收款";
        barTitle = (TextView) findViewById(R.id.title_text);
        barTitle.setText(activityTitle);

        editText = (EditText) findViewById(R.id.receipt_amount);
        editText.addTextChangedListener(new DecimalFilter(editText, this));     // Limit the decimal digits to 2

        confirmButton = (Button) findViewById(R.id.button_confirm_receipt);
        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ReceiptActivity.this, TransactionActivity.class);
                intent.putExtra("task_name", activityTitle);
                startActivity(intent);
            }
        });
    }
}
