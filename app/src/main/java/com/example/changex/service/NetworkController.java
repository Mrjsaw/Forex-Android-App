package com.example.changex.service;

import android.content.Context;
import android.util.Log;


import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

public class NetworkController {
    private static NetworkController mInstance;
    private RequestQueue mRequestQueue;
    private static Context mCtx;
    private String url ="https://api.exchangeratesapi.io/";

    private NetworkController(Context context) {
        mCtx = context.getApplicationContext();
        mRequestQueue = getRequestQueue();

    }
    public static synchronized NetworkController getInstance(Context context) {
        // If instance is not available, create it. If available, reuse and return the object.
        if (mInstance == null) {
            mInstance = new NetworkController(context);
        }
        return mInstance;
    }
    public RequestQueue getRequestQueue() {
        if (mRequestQueue == null) {
            // getApplicationContext() is key. It should not be activity context,
            // or else RequestQueue won’t last for the lifetime of your app
            mRequestQueue = Volley.newRequestQueue(mCtx.getApplicationContext());
        }
        return mRequestQueue;
    }
    public  void addToRequestQueue(Request req) {
        if (req != null) {
            getRequestQueue().add(req);
        }
    }

    public JSONObject getLatestHTTP(String apicall, String base) {
        JSONObject obj = new JSONObject();
        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.GET,
                url+apicall+base, null,
                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d("NetworkCtrl:", response.toString());
                        //obj = response;
                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("NetworkController", error.toString());
            }
        });
        mRequestQueue.add(jsonObjReq);
        return obj;
    }
}