package com.example.changex;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;


public class NetworkAdapter extends Application {
    private static NetworkAdapter mInstance;
    private RequestQueue requestQueue;
    private static Context ctx;
    private static String rates = "1.64";

    private NetworkAdapter(Context context) {
        ctx = context;
        requestQueue = getRequestQueue();
    }
    public void getData(String base) {
        String url = "https://api.exchangeratesapi.io/latest?base="+base+"&symbols=USD&symbols=EUR&symbols=AUD&symbols=GBP&symbols=JPY&symbols=CAD&symbols=CNY&symbols=INR&symbols=HKD&symbols=IDR&symbols=TRY";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                       Log.i("NetworkAdapter", response);
                       rates = response;
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // Handle error
                        Log.i("NetworkAdapter", error.toString());
                    }
                });

        requestQueue.add(stringRequest);

    }
    public static synchronized NetworkAdapter getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new NetworkAdapter(context);
        }
        return mInstance;
    }

    public RequestQueue getRequestQueue() {
        if (requestQueue == null) {
            requestQueue = Volley.newRequestQueue(ctx.getApplicationContext());
        }
        return requestQueue;
    }
    public <T> void addToRequestQueue(Request<T> req) {
        getRequestQueue().add(req);
    }
    public String getRates() {
        return rates;
    }


}

