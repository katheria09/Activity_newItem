package com.mrhot.activity_newitem;

import android.content.Context;
import android.widget.Toast;

import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

/**
 * Created by KunwarShekhar on 06-Oct-16.
 */

public class HttpCall {


    public void getItemDetails (final Context context) {
        RequestParams requestParams = new RequestParams();
      //  requestParams.put("day", day);
       // requestParams.put("shift", shift);


        EndPoints.getItemDetails(requestParams, new JsonHttpResponseHandler() {

                    @Override
                    public void onStart() {

                    }

                    @Override
                    public void onSuccess(int statusCode, Header[] headers, JSONObject response) {



                        new DataParser().parseItemDetails(context, response);


                    }

                    @Override
                    public void onFailure(int statusCode, Header[] headers,
                                          Throwable throwable, JSONObject errorResponse) {
                        Toast.makeText(context, "Please try again later", Toast.LENGTH_SHORT).show();
                    }

                }
        );

    }



}