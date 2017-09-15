package co.bankoo.patrick.cardmanager.Controllers;

import android.app.Activity;
import android.view.inputmethod.InputMethodManager;

/**
 * Created by patrick on 15/09/2017.
 */

public class Utility {

    public static void hideSoftKeyboard(Activity activity) {
        InputMethodManager inputMethodManager =
                (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(
                activity.getCurrentFocus().getWindowToken(), 0);
    }

}
