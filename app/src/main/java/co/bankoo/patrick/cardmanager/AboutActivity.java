package co.bankoo.patrick.cardmanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import co.bankoo.patrick.cardmanager.Controllers.BaseActivity;

public class AboutActivity extends BaseActivity {

    String activityTitle;
    TextView barTitle;
    TextView companyIntro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        // Setup action bar
        activityTitle = "关于我们";
        barTitle = (TextView) findViewById(R.id.title_text);
        barTitle.setText(activityTitle);

        // Show company description in About Us
        companyIntro = (TextView) findViewById(R.id.about_company_info);
        companyIntro.setText(R.string.company_info);
    }
}
