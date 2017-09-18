package co.bankoo.patrick.cardmanager;

import android.app.ActionBar;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import co.bankoo.patrick.cardmanager.Controllers.BaseActivity;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        actionBarSetup();

        // Setup button for Receipt
        Button receiptButton = (Button) findViewById(R.id.button_receipt);
        receiptButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ReceiptActivity.class);
                startActivity(intent);
            }
        });

        // Setup button for Payment
        Button payButton = (Button) findViewById(R.id.button_pay);
        payButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, PayActivity.class);
                startActivity(intent);
            }
        });

        // Setup button for Handle
        ImageButton handleButton = (ImageButton) findViewById(R.id.button_handle);
        handleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, HandleActivity.class);
                startActivity(intent);
            }
        });

        // Setup button for Search
        ImageButton searchButton = (ImageButton) findViewById(R.id.button_search);
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SearchActivity.class);
                startActivity(intent);
            }
        });

        // Setup button for Setting
        ImageButton settingButton = (ImageButton) findViewById(R.id.button_set);
        settingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SettingActivity.class);
                startActivity(intent);
            }
        });

        // Setup button for Phone
        ImageButton phoneButton = (ImageButton) findViewById(R.id.button_phone);
        phoneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:110"));
                startActivity(callIntent);
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
