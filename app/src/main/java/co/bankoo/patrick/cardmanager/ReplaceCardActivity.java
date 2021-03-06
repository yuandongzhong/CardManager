package co.bankoo.patrick.cardmanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import co.bankoo.patrick.cardmanager.Controllers.BaseActivity;

import static co.bankoo.patrick.cardmanager.Controllers.Utility.hideSoftKeyboard;

public class ReplaceCardActivity extends BaseActivity {

    Button confirmButton;
    String activityTitle;
    TextView barTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_replace_card);

        activityTitle = "补卡";
        barTitle = (TextView) findViewById(R.id.title_text);
        barTitle.setText(activityTitle);

        setupUI(findViewById(R.id.activity_replace_card));

        confirmButton = (Button) findViewById(R.id.replacecard_button_confirm);
        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ReplaceCardActivity.this, UserInfoActivity.class);
                intent.putExtra("task_name", activityTitle);
                startActivity(intent);
            }
        });

        // Spinner for 性别
        Spinner spinnerSex = (Spinner) findViewById(R.id.replacecard_spinner_sex);
        ArrayAdapter<CharSequence> sexAdapter = ArrayAdapter.createFromResource(this, R.array.sex_array, android.R.layout.simple_spinner_item);
        sexAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerSex.setAdapter(sexAdapter);
    }


    // This method is to hide the keyboard by clicking on views other than TextEdit views
    public void setupUI(View view) {

        // Set up touch listener for non-text box views to hide keyboard.
        if (!(view instanceof EditText)) {
            view.setOnTouchListener(new View.OnTouchListener() {
                public boolean onTouch(View v, MotionEvent event) {
                    hideSoftKeyboard(ReplaceCardActivity.this);
                    return false;
                }
            });
        }

        //If a layout container, iterate over children and seed recursion.
        if (view instanceof ViewGroup) {
            for (int i = 0; i < ((ViewGroup) view).getChildCount(); i++) {
                View innerView = ((ViewGroup) view).getChildAt(i);
                setupUI(innerView);
            }
        }
    }
}
