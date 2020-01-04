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

import java.util.ArrayList;
import java.util.List;


public class NetworkAdapter extends Application {
    private static NetworkAdapter mInstance;
    private RequestQueue requestQueue;
    private static Context ctx;
    private static String temp = "{\"rates\":{\"CAD\":1.2981968243,\"INR\":71.7758141204,\"EUR\":0.8971023594,\"CNY\":6.9715618552,\"USD\":1.0,\"GBP\":0.7635686732,\"TRY\":5.9735354804,\"AUD\":1.4381447923,\"JPY\":108.1367183996,\"HKD\":7.7790436889,\"IDR\":13938.0012559433},\"base\":\"USD\",\"date\":\"2020-01-03\"}";
    private static List<String> rates;
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
                        jsonStringToList(response);
                        temp = response.substring(55,61);
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
        return temp;
    }
    public List<String> jsonStringToList(String json) {
        String temp = json.substring(10,json.length()-34);
        Log.i("JsonList:",temp);
        List<String> myCurrencies = new ArrayList<>();
        myCurrencies.add(json.substring(16,22));
        myCurrencies.add(json.substring(35,41));
        myCurrencies.add(json.substring(55,61));

        return myCurrencies;
    }


}

