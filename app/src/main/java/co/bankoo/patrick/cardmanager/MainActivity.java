package co.bankoo.patrick.cardmanager;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        actionBarSetup();

        Button receiptButton = (Button) findViewById(R.id.button_receipt);
        receiptButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ReceiptActivity.class);
                startActivity(intent);
            }
        });

    }

    /**
     * Sets customized Action Bar
     */

    private void actionBarSetup() {
        getSupportActionBar().setTitle("广州XXX科技有限公司");
        getSupportActionBar().setSubtitle("商户管理员");
    }
}
