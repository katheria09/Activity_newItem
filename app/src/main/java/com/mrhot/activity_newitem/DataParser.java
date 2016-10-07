package com.mrhot.activity_newitem;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by KunwarShekhar on 06-Oct-16.
 */

public class DataParser {
    public void parseItemDetails(Context context, JSONObject jsonObject) {

        ArrayList<Model_itemDetails> arrayList = new ArrayList<>();

        try {
            {

                JSONArray message = jsonObject.getJSONArray("data");

                boolean success = false;

                for (int i = 0; i < message.length(); i++) {

                    JSONObject temp = message.getJSONObject(i);
                    if (i == 0) {
                        if (temp.getString("success").equals("1")) {
                            success = true;
                        }
                    }
                    if (i != 0 && success) {
                        Model_itemDetails model_itemDetails = new Model_itemDetails();
                        //modalItemCode.itemCode = temp.getString("itemCode");
                        model_itemDetails.itemName = temp.getString("itemName");
                        model_itemDetails.itemPrice = temp.getString("itemPrice");
                        // model_itemDetails.itemDescription = temp.getString("itemDescription");
                        model_itemDetails.itemCategory = temp.getString("itemCategory");

                        arrayList.add(model_itemDetails);
                    }


                }

                Activity_newItem.getInstance().setData(context, arrayList);


            }
        } catch (JSONException e1) {
            e1.printStackTrace();
        }


    }



}
