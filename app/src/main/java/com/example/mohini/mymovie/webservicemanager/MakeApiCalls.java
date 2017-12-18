package com.example.mohini.mymovie.webservicemanager;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.util.Log;

import com.example.mohini.mymovie.R;
import com.example.mohini.mymovie.utility.Utility;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Converter;
import retrofit2.Response;

/**
 * Created by mohini on 18/12/17.
 */

public interface MakeApiCalls {

    String LOGIN_KEY = "login_key";
    /**
     * Listener to listen for the success
     * the network call
     */
    public interface CallListener {
        void onCallSuccess(Object result, String key);
    }

    /**
     * Common call from all the activities
     */
    public static void CommonCall(Call call, final Context context, final CallListener listener, final String key) {
        if (context != null) {
            //set progress dialog
            final ProgressDialog progressDialog = new ProgressDialog(context);
            progressDialog.setMessage(context.getString(R.string.loading_message));
            progressDialog.show( );
            //noinspection unchecked

            call.enqueue(new Callback<Object>( ) {
                @Override
                public void onResponse(Call<Object> call, Response<Object> response) {

                    progressDialog.dismiss( );
                    if ((response.body( ) != null) && (listener != null)) {

                        listener.onCallSuccess(response.body( ), key);

                    } else {
                        Log.d("response", "code = " + response.code( ));
                        Log.d("response: ", "body = " + response.body( ));
                        // Look up a converter for the Error type on the Retrofit instance.
                        Converter<ResponseBody, Error> errorConverter =
                                ApiClient.retrofit.responseBodyConverter(Error.class, new java.lang.annotation.Annotation[0]);
                        try {
                            Error error = errorConverter.convert(response.errorBody( ));
                            Utility.showToast((Activity) context, error.getMessage( ));
                        } catch (IOException e) {
                            e.printStackTrace( );
                        }
                    }
                }

                @Override
                public void onFailure(Call<Object> call, Throwable t) {

                    progressDialog.dismiss( );
                    Utility.showToast((Activity) context, "Something went wrong");
                    t.printStackTrace( );
                }
            });
        }
    }
}
