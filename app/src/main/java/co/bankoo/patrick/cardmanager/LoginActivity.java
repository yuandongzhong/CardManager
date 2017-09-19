package co.bankoo.patrick.cardmanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    String activityTitle;
    TextView barTitle;
    Button loginButton;
    EditText accountInput;
    EditText passwordInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Setup action bar
        activityTitle = "登录";
        barTitle = (TextView) findViewById(R.id.title_text);
        barTitle.setText(activityTitle);

        // Setup EditText view
        accountInput = (EditText) findViewById(R.id.login_phone_number);
        passwordInput = (EditText) findViewById(R.id.login_password);

        // Setup logic for the login button
        setLoginButton();
    }

    private void setLoginButton() {
        loginButton = (Button) findViewById(R.id.login_button_login);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Receive login info from the EditText views
                String accountNumber = accountInput.getText().toString();
                String password = passwordInput.getText().toString();

                // Check if the login info is correct
                if (("1234".equals(accountNumber)) && ("admin".equals(password))) {
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                } else if (!"1234".equals(accountNumber)) {
                    Toast.makeText(LoginActivity.this, "请输入正确的手机号码", Toast.LENGTH_SHORT).show();
                } else if (!"admin".equals(password)) {
                    Toast.makeText(LoginActivity.this, "密码不正确", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
