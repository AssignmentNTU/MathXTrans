package com.example.edwardsujono.mathxtrans.manager;

import android.widget.TextView;

import com.example.edwardsujono.mathxtrans.constant.Api;
import com.loopj.android.http.*;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayInputStream;

import cz.msebera.android.httpclient.Header;

/**
 * Created by edwardsujono on 19/6/17.
 */

public class SearchManager {

    private static String api_call = Api.TRANSLATE_API;

    public String callAPITranslate(final TextView textView, byte[] myByteArray){

        RequestParams params = new RequestParams();
        params.put("file", new ByteArrayInputStream(myByteArray), "image_translation.jpg");

        AsyncHttpClient client = new AsyncHttpClient();
        client.post(api_call, params, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                try {
                    JSONObject jsonObject = new JSONObject(new String(responseBody));
                    textView.setText(jsonObject.getString("list_answer"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });

        return "";
    }

}
