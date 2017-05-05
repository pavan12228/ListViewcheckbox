package com.example.ravinderreddy.listviewdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private ListView lvStarNames;
    private Button btSubmit;

    private int[] images = new int[]{R.drawable.brown_star, R.drawable.green_star, R.drawable.green_star,
            R.drawable.ligh_green_star, R.drawable.orange_star, R.drawable.pink_star, R.drawable.red_star, R.drawable.yello_start,
            R.drawable.brown_star, R.drawable.green_star, R.drawable.green_star,
            R.drawable.ligh_green_star, R.drawable.orange_star, R.drawable.pink_star, R.drawable.red_star, R.drawable.yello_start,
            R.drawable.brown_star, R.drawable.green_star, R.drawable.green_star,
            R.drawable.ligh_green_star, R.drawable.orange_star, R.drawable.pink_star, R.drawable.red_star, R.drawable.yello_start,
            R.drawable.brown_star, R.drawable.green_star, R.drawable.green_star,
            R.drawable.ligh_green_star, R.drawable.orange_star, R.drawable.pink_star, R.drawable.red_star, R.drawable.yello_start};

    String names[] = {"" +
            " =brown star", "grey star", "green star", "light green star", "orange star", "pink start", "red star", "yello start",
            "brown star", "grey star", "green star", "light green star", "orange star", "pink start", "red star", "yello start",
            "brown star", "grey star", "green star", "light green star", "orange star", "pink start", "red star", "yello start",
            "brown star", "grey star", "green star", "light green star", "orange star", "pink start", "red star", "yello start"};

    private List<StartModel> startModelList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvStarNames = (ListView) findViewById(R.id.activity_main_lv);
        btSubmit = (Button) findViewById(R.id.activity_main_submit);

        for (int i = 0; i < images.length; i++) {
            StartModel startModel = new StartModel();
            startModel.setChecked(false);
            startModel.setSelected(false);
            startModel.setStartImage(images[i]);
            startModelList.add(startModel);
        }

        LiveAdapter liveAdapter = new LiveAdapter(startModelList, getApplicationContext(),btSubmit);
        lvStarNames.setAdapter(liveAdapter);

    }
}
