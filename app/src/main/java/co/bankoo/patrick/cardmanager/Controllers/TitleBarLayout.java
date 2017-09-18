package co.bankoo.patrick.cardmanager.Controllers;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import co.bankoo.patrick.cardmanager.R;

import static java.security.AccessController.getContext;

/**
 * Created by patrick on 10/09/2017.
 */


public class TitleBarLayout extends LinearLayout {
    public TitleBarLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.title_bar, this);

        /*
            Setup the Go Back button on action bar
         */
        ImageButton titleBackButton = (ImageButton) findViewById(R.id.title_back_button);
        titleBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((Activity) getContext()).finish();
            }
        });
    }

}
