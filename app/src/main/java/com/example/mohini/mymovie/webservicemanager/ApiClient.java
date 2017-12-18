package com.example.mohini.mymovie.webservicemanager;

/**
 * Created by mohini on 18/12/17.
 */

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.concurrent.TimeUnit;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
public class ApiClient {

   private static final Gson gson = new GsonBuilder().setLenient().create();

   static Retrofit retrofit;

   // get retrofit client object
   private static final Retrofit.Builder builder =
           new Retrofit.Builder()
                   .baseUrl(HttpUrl.parse(ApiConstant.host_url_resource))
                   .addConverterFactory(GsonConverterFactory.create(gson));

   // create session
   public static <S> S createService(Class<S> serviceClass) {
      HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
      interceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
      OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).connectTimeout(30, TimeUnit.SECONDS)
              .readTimeout(30, TimeUnit.SECONDS).writeTimeout(30, TimeUnit.SECONDS).build();

      retrofit = builder.client(client).build();
      return retrofit.create(serviceClass);
   }
}
