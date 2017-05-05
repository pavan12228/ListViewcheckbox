package com.example.ravinderreddy.listviewdemo;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ravinder Reddy on 22-04-2017.
 */

public class LiveAdapter extends BaseAdapter{

    private List<StartModel> startModelList;
    private Context mContext;
    private Button btSubmit;
    private LayoutInflater inflater;

    public LiveAdapter(List<StartModel> startModelList, Context mContext, Button btSubmit) {
        this.startModelList = startModelList;
        this.mContext = mContext;
        this.btSubmit=btSubmit;
        inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getCount() {
        return startModelList.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
     ViewHolder viewHolder = null;

        if (convertView == null) {
            convertView= inflater.inflate(R.layout.inflator_layout,null);
            viewHolder = new ViewHolder();
            viewHolder.imageView = (ImageView) convertView.findViewById(R.id.inflator_layout_iv);
            viewHolder.checkBox = (CheckBox) convertView.findViewById(R.id.inflator_layout_cb);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }


        viewHolder.imageView.setImageResource(startModelList.get(position).getStartImage());
        viewHolder.checkBox.setChecked(startModelList.get(position).isChecked());


        viewHolder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                    StartModel startModel =  startModelList.get(position);
//                    startModel.setChecked(isChecked);
//
//                    startModelList.remove(position);
//                    startModelList.add(position,startModel);
                startModelList.get(position).setSelected(isChecked);
                startModelList.get(position).setChecked(isChecked);

            }
        });
        btSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                List<StartModel> startModelList1=new ArrayList<StartModel>();
                for (int i = 0; i < startModelList.size(); i++) {
                    if(startModelList.get(i).isSelected() ){
                        startModelList1.add(startModelList.get(i));
                    }
                }

                Intent intent=new Intent(mContext,SecondActivity.class);
                intent.putExtra("selectedValues", (Serializable) startModelList1);
                mContext.startActivity(intent);

            }
        });

        return convertView;
    }
    private  class ViewHolder{
        private ImageView imageView;
        private CheckBox checkBox;
    }


    @Override
    public int getViewTypeCount() {

        return getCount();
    }

    @Override
    public int getItemViewType(int position) {

        return position;
    }
}
