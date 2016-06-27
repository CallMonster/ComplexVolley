package com.restaurant.chaersi.complexvolley.base;

import android.app.Application;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.OkHttpStack;
import com.android.volley.toolbox.SSLRequestUtils;
import com.android.volley.toolbox.Volley;

import javax.net.ssl.SSLSocketFactory;

import okhttp3.OkHttpClient;

/**
 * Created by Chaersi on 16/6/27.
 */
public class BaseApplication extends Application {
    public static final String TAG = "BaseApplication";
    public final String CA_FILE_DIR="";

    public static BaseApplication mInstance;
    private RequestQueue mRequestQueue;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;

        Volley.CACHE_DIR="";
    }

    public static synchronized BaseApplication getInstance() {
        return mInstance;
    }

    public RequestQueue getRequestQueue() {
        if (mRequestQueue == null) {
            mRequestQueue = Volley.newRequestQueue(getApplicationContext(),new OkHttpStack(new OkHttpClient()));
        }
        return mRequestQueue;
    }

    public <T> void addRequest(Request<T> req, String tag) {
        req.setTag(tag);
        getRequestQueue().add(req);

    }

    public <T> void addRequest(Request<T> req) {
        req.setTag(TAG);
        getRequestQueue().add(req);
    }

    public RequestQueue getSSLRequestQueue(String cer){
        if(mRequestQueue==null){
            mRequestQueue=Volley.newSSLRequestQueue(getApplicationContext(),cer);
        }
        return mRequestQueue;
    }

    public <T> void addSSLRequest(Request<T> req){
        req.setTag(TAG);
        RequestQueue queue=getSSLRequestQueue(CA_FILE_DIR);
        if(queue!=null){
            queue.add(req);
        }
    }

    public void cancelRequests(Object tag) {
        if (mRequestQueue != null) {
            mRequestQueue.cancelAll(tag);
        }
    }


}
