package com.mrhot.activity_newitem;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by KunwarShekhar on 06-Oct-16.
 */

public class ItemDescriptionAdapter extends RecyclerView.Adapter<ItemDescriptionAdapter.MyViewHolder> {


    private ArrayList<Model_itemDetails> arrayList;
    Context context;

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvname,tvprice,tvcategory;
        public MyViewHolder(View itemView){
            super(itemView);
            this.tvname = (TextView) itemView.findViewById(R.id.tvName_item);
            this.tvprice= (TextView) itemView.findViewById(R.id.tvPrice_item);
            this.tvcategory= (TextView) itemView.findViewById(R.id.tvCategory_item);

        }

    }

    public  ItemDescriptionAdapter(Context context,ArrayList<Model_itemDetails> people){
        this.arrayList = people;
        this.context = context;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_new_item,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        final  Model_itemDetails model_itemDetails = arrayList.get(position);
        TextView tvname = holder.tvname;
        TextView tvprice = holder.tvprice;
        TextView tvcategory = holder.tvcategory;
        tvname.setText(model_itemDetails.itemName);
        tvprice.setText(model_itemDetails.itemPrice);
        tvcategory.setText(model_itemDetails.itemCategory);

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }



}
