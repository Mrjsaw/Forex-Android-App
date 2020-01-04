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
import java.util.Map;


public class NetworkAdapter extends Application {
    private static NetworkAdapter mInstance;
    private RequestQueue requestQueue;
    private static Context ctx;
    private static String temp = "{\"rates\":{\"CAD\":1.2981968243,\"INR\":71.7758141204,\"EUR\":0.8971023594,\"CNY\":6.9715618552,\"USD\":1.0,\"GBP\":0.7635686732,\"TRY\":5.9735354804,\"AUD\":1.4381447923,\"JPY\":108.1367183996,\"HKD\":7.7790436889,\"IDR\":13938.0012559433},\"base\":\"USD\",\"date\":\"2020-01-03\"}";
    private static ArrayList<String> rates;
    private NetworkAdapter(Context context) {
        ctx = context;
        requestQueue = getRequestQueue();
        rates = jsonStringToList(temp);
    }

    //Deze free version update maar 1 x uur
    public void getData(String base) {
        String url = "https://api.exchangeratesapi.io/latest?base="+base+"&symbols=USD&symbols=EUR&symbols=AUD&symbols=GBP&symbols=JPY&symbols=CAD&symbols=CNY&symbols=INR&symbols=HKD&symbols=IDR&symbols=TRY";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                       Log.i("NetworkAdapter", response);
                        rates = jsonStringToList(response);
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
    public ArrayList<String> getRates() {
        return rates;
    }

    public ArrayList<String> jsonStringToList(String json) {
        String temp = json.substring(10,json.length()-35);
        Log.i("temp:",temp);
        ArrayList<String> newArr = new ArrayList<>();
        ArrayList<String> ss = new ArrayList<>();
        for(String w: temp.split(",")) {
            for (String q: w.split(":")) {
                ss.add(q);
            }
        }
        for (int x = 0; x < 11; x++) {
            newArr.add(ss.get(x*2+1));
            Log.i("arr:", ss.get(x*2+1));
        }
        ArrayList<String> tempList = new ArrayList<>(10);
        tempList.add(newArr.get(4)); //USD
        tempList.add(newArr.get(2)); //EUR
        tempList.add(newArr.get(5)); //GBP
        tempList.add(newArr.get(8)); //JPY
        tempList.add(newArr.get(0)); //CAD
        tempList.add(newArr.get(3)); //CNY
        tempList.add(newArr.get(1)); //IDR
        tempList.add(newArr.get(9)); //HKD
        tempList.add(newArr.get(7)); //AUD
        tempList.add(newArr.get(10)); //IDR
        tempList.add(newArr.get(6)); //TRY
        return tempList;
    }


}

