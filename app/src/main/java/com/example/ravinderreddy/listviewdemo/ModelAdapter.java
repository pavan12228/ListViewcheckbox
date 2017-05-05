package com.example.ravinderreddy.listviewdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by Ravinder Reddy on 23-04-2017.
 */

public class ModelAdapter extends BaseAdapter
{
   private Context mContext;
    private List<StartModel> startModelsList;
    private LayoutInflater mInflater;

    public ModelAdapter(Context mContext, List<StartModel> startModelsList) {
        this.mContext = mContext;
        this.startModelsList = startModelsList;
        mInflater= (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        return startModelsList.size();
    }

    @Override
    public Object getItem(int position) {
        return startModelsList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder  viewHolder;
        if (convertView==null){
            viewHolder=new ViewHolder();
           convertView =  mInflater.inflate(R.layout.inflator_layout,null);
            viewHolder.iv= (ImageView) convertView.findViewById(R.id.inflator_layout_iv);
            viewHolder.cb= (CheckBox) convertView.findViewById(R.id.inflator_layout_cb);
            convertView.setTag(viewHolder);



        }
        else {
            viewHolder= (ViewHolder) convertView.getTag();

        }

        viewHolder.iv.setImageResource(startModelsList.get(position).getStartImage());
        viewHolder.cb.setChecked(startModelsList.get(position).isChecked());

        return convertView;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public int getViewTypeCount() {
        return getCount();
    }

    private class ViewHolder{
        ImageView iv;
        CheckBox cb;



    }
}
