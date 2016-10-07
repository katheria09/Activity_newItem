package com.mrhot.activity_newitem;

import android.content.Context;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

public class Activity_newItem extends AppCompatActivity implements View.OnClickListener {

    Context context = Activity_newItem.this;
    RecyclerView recyclerView;
    static Activity_newItem activity_newItem;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_item);
        activity_newItem= this;
        itit();
        setUpToolBar();
        setUpRecyclerView();

    }

    private void setUpRecyclerView() {
        new HttpCall().getItemDetails(context);
    }
    public static Activity_newItem getInstance(){
        return activity_newItem;
    }

    private void setUpToolBar() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("Choose Meal");

    }

    private void itit() {
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context) ;
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);


    }

    @Override
    public void onClick(View v) {

    }
    public void setData(final Context context, final ArrayList<Model_itemDetails> arrayList){

        ((Activity_newItem)context).runOnUiThread(new Runnable() {
            @Override
            public void run() {
                ItemDescriptionAdapter itemDescriptionAdapter = new ItemDescriptionAdapter(context,arrayList);
                recyclerView.setAdapter(itemDescriptionAdapter);

            }
        });
    }
}
