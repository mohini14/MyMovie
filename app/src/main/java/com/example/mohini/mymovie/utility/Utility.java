package com.example.mohini.mymovie.utility;

import android.app.Activity;
import android.widget.Toast;

/**
 * Created by mohini on 14/12/17.
 */

public class Utility  {

//    //method to  dismiss keyboard on touch
//    @Override
//    public boolean dispatchTouchEvent(MotionEvent event) {
//        View view = getCurrentFocus();
//        boolean ret = super.dispatchTouchEvent(event);
//
//        if (view instanceof EditText) {
//            View w = getCurrentFocus();
//            int scrcoords[] = new int[2];
//            w.getLocationOnScreen(scrcoords);
//            float x = event.getRawX() + w.getLeft() - scrcoords[0];
//            float y = event.getRawY() + w.getTop() - scrcoords[1];
//
//            if (event.getAction() == MotionEvent.ACTION_UP
//                    && (x < w.getLeft() || x >= w.getRight()
//                    || y < w.getTop() || y > w.getBottom()) ) {
//                InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
//                imm.hideSoftInputFromWindow(getWindow().getCurrentFocus().getWindowToken(), 0);
//            }
//        }
//        return ret;
//    }

    public static void showToast(Activity act, String message){

        Toast toast=Toast.makeText(act.getApplicationContext(), message,Toast.LENGTH_LONG);
        toast.show();
    }
}
