package Utility;

import android.app.Activity;
import android.view.inputmethod.InputMethodManager;

/**
 * Created by mohini on 14/12/17.
 */

public class Utility  {

    public static void hideSoftKeyboard(Activity activity) {
        InputMethodManager inputMethodManager =
                (InputMethodManager) activity.getSystemService(
                        Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(
                activity.getCurrentFocus().getWindowToken(), 0);
    }
}
