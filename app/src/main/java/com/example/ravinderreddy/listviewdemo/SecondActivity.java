package com.example.ravinderreddy.listviewdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.List;

/**
 * Created by Ravinder Reddy on 23-04-2017.
 */

public class SecondActivity extends AppCompatActivity
{
     ListView mListView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
        mListView= (ListView) findViewById(R.id.acitivity_main1_listview);
       List<StartModel> startModelList= (List<StartModel>) getIntent().getSerializableExtra("selectedValues");


        ModelAdapter  modelAdapter=new ModelAdapter(this,startModelList);
        mListView.setAdapter(modelAdapter);

    }
}
