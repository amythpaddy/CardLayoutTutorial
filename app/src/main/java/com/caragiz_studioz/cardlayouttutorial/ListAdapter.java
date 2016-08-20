package com.caragiz_studioz.cardlayouttutorial;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by caragiz on 11-08-2016.
 */
public class ListAdapter extends BaseAdapter implements DialogInterface.OnClickListener {

    private Activity activity;
    private static LayoutInflater inflater = null;
    public Resources resource;
    ArrayList<String> data = new ArrayList<>();
    int i = 0;

    ListAdapter(Activity activity , Resources resource){
        this.activity = activity;
        this.resource = resource;

        inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        fillData();
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    public static class ViewHolder{
        public TextView textView;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        View view = convertView;
        ViewHolder holder;

        if(convertView == null){
            view = inflater.inflate(R.layout.cardlayout , null);
            holder = new ViewHolder();
            holder.textView = (TextView)view.findViewById(R.id.info_text);

            view.setTag(holder);
        }else{
            holder = (ViewHolder)view.getTag();
        }

        holder.textView.setText(data.get(i));
        view.setOnClickListener(new ListClickListener(i));
        return view;
    }

    @Override
    public void onClick(DialogInterface dialogInterface, int i) {
        Log.v("CustomAdapter", "=====Row button clicked=====");
    }

    private class ListClickListener implements View.OnClickListener{

        int position;
        ListClickListener(int position){
            this.position = position;
        }
        @Override
        public void onClick(View view) {
            Toast.makeText(activity.getApplicationContext() , "List selected at:"+position , Toast.LENGTH_LONG).show();
        }
    }

    private void fillData(){
        for(int i=0 ; i< 100 ; i++)
            data.add("a");

    }
}
