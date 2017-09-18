package co.bankoo.patrick.cardmanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import co.bankoo.patrick.cardmanager.Controllers.BaseActivity;

public class ReadCardActivity extends BaseActivity {

    ImageButton closeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_card);

        closeButton = (ImageButton) findViewById(R.id.read_card_button_close);
        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ReadCardActivity.this, HandleResultActivity.class);
                startActivity(intent);
            }
        });
    }


}
