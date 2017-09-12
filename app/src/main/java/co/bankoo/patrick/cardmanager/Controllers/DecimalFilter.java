package co.bankoo.patrick.cardmanager.Controllers;

/**
 * Created by patrick on 10/09/2017.
 */

import android.app.Activity;
import android.os.Handler;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.EditText;
import android.widget.Toast;

public class DecimalFilter implements TextWatcher {

    int count = -1;
    EditText et;
    Activity activity;

    public DecimalFilter(EditText editText, Activity activity) {
        et = editText;
        this.activity = activity;
    }

    public void afterTextChanged(Editable s) {
        if (s.length() > 0) {
            String str = et.getText().toString();
            et.setOnKeyListener(new OnKeyListener() {
                public boolean onKey(View v, int keyCode, KeyEvent event) {
                    if (keyCode == KeyEvent.KEYCODE_DEL) {
                        count--;
                        InputFilter[] fArray = new InputFilter[1];
                        fArray[0] = new InputFilter.LengthFilter(100);//Re sets the maxLength of edittext to 100.
                        et.setFilters(fArray);
                    }
                    if (count > 2) {

                        final Toast toast = Toast.makeText(activity, "不能超出2个小数点", Toast.LENGTH_SHORT);
                        toast.show();

                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                toast.cancel();
                            }
                        }, 1000);
                    }
                    return false;
                }
            });

            char t = str.charAt(s.length() - 1);

            if (t == '.') {
                count = 0;
            }

            if (count >= 0) {
                if (count == 2) {
                    InputFilter[] fArray = new InputFilter[1];
                    fArray[0] = new InputFilter.LengthFilter(s.length());
                    et.setFilters(fArray); // sets edit text's maxLength to number of digits now entered.

                }
                count++;
            }
        }
    }

    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        // TODO Auto-generated method stub
    }

    public void onTextChanged(CharSequence s, int start, int before, int count) {
        // TODO Auto-generated method stub
    }

}

