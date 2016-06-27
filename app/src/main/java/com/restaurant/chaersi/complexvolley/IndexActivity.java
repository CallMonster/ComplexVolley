package com.restaurant.chaersi.complexvolley;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.restaurant.chaersi.complexvolley.base.BaseApplication;

import butterknife.BindView;
import butterknife.ButterKnife;

public class IndexActivity extends AppCompatActivity {

    @BindView(R.id.simpleView) TextView simpleView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple);
        ButterKnife.bind(this);

        BaseApplication.mInstance.addRequest(request);


    }

    StringRequest request = new StringRequest(Request.Method.GET,
            "https://e.abchina.com/tj/emobile_payment/MainServlet",
            new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    simpleView.setText("正确:"+response);
                }
            },
            new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    simpleView.setText("错误："+error.toString());
                }
            });


}
