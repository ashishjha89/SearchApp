package com.ashishjha.searchapp.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;

/**
 * Created by ashish on 5/3/16.
 */
public class Utils {

    public static final String CX = "016984821312013428759:n_p-wh7xbnc";

    public static final String API_KEY = "AIzaSyARpUwhyW6jkmc3b_EpwbW5_TJIxV-u0ik";

    public static boolean isNetworkAvailable(Context context) {
        if (context == null) {
            return false;
        }
        ConnectivityManager connectivityManager
                = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public static Bitmap getBitmapFromURL(String src) {
        if (src == null) {
            return null;
        }
        HttpURLConnection connection = null;
        InputStream input = null;
        try {
            java.net.URL url = new java.net.URL(src);
            connection = (HttpURLConnection) url
                    .openConnection();
            connection.setDoInput(true);
            connection.setRequestMethod("GET");
            connection.connect();
            input = connection.getInputStream();
            return BitmapFactory.decodeStream(input);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                connection.disconnect();
            }
        }
    }
}
