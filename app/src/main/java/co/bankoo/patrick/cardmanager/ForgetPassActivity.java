package co.bankoo.patrick.cardmanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import co.bankoo.patrick.cardmanager.Controllers.BaseActivity;

import static co.bankoo.patrick.cardmanager.Controllers.Utility.hideSoftKeyboard;

public class ForgetPassActivity extends BaseActivity {

    String activityTitle;
    TextView barTitle;
    LinearLayout resetLayout;           // Reset page   （重设密码）
    LinearLayout validationLayout;      // Validation page      （短信验证）
    EditText phoneNumberInput;          // Input for phone number
    EditText validationCodeInput;       // Inout for validation code (received from server)
    EditText newPassInput;              // Input for new password
    EditText confirmPassInput;          // Confirm by entering the new password again
    Button submitButton;                // Send & confirm validation code
    Button resetButton;                 // Confirm & reset new password

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_pass);
        setupUI(findViewById(R.id.activity_forget_pass));                 // Auto hide keyboard for TextEdit views

        // Setup action bar
        activityTitle = "找回密码";
        barTitle = (TextView) findViewById(R.id.title_text);
        barTitle.setText(activityTitle);

        /*
         *  Setup for the validation page
         */
        validationLayout = (LinearLayout) findViewById(R.id.forget_pass_layout_validation);
        phoneNumberInput = (EditText) findViewById(R.id.forget_pass_edit_phone_number);
        validationCodeInput = (EditText) findViewById(R.id.forget_pass_edit_validation_code);
        submitButton = (Button) findViewById(R.id.forget_pass_button_confirm_validation);
        setSubmitButton();          // Logic for clicking on the '提交' button

        /*
         *  Setup for the reset page
         */
        resetLayout = (LinearLayout) findViewById(R.id.forget_pass_layout_reset);
        resetLayout.setVisibility(View.INVISIBLE);          // Hide the reset page before entering the validation code
        newPassInput = (EditText) findViewById(R.id.forget_pass_edit_new_pass);
        confirmPassInput = (EditText) findViewById(R.id.forget_pass_edit_confirm_pass);
        resetButton = (Button) findViewById(R.id.forget_pass_button_confirm_reset);

        // TODO: Logics for after resetting the password
    }


    // Logic for "提交" button in the validation page
    private void setSubmitButton() {
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Check if the validation code is correct
                if("1234".equals(validationCodeInput.getText().toString())) {
                    // Switching to the reset page
                    toReset();
                } else {
                    Toast.makeText(ForgetPassActivity.this, "验证码错误", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    // Switching to the reset page after user submitting the correct validation code
    private void toReset() {

        // Hide the validation page
        validationLayout.setVisibility(View.GONE);
        // Show the reset page
        resetLayout.setVisibility(View.VISIBLE);
    }

    // This method is to hide the keyboard by clicking on views other than TextEdit views
    public void setupUI(View view) {
        // Set up touch listener for non-text box views to hide keyboard.
        if (!(view instanceof EditText)) {
            view.setOnTouchListener(new View.OnTouchListener() {
                public boolean onTouch(View v, MotionEvent event) {
                    hideSoftKeyboard(ForgetPassActivity.this);
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
