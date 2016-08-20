package com.caragiz_studioz.cardlayouttutorial;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by caragiz on 12-08-2016.
 */
public class RecycleViewAdapter extends RecyclerView.Adapter<TutorialHolder> {

    @Override
    public TutorialHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardlayout , parent , false);
        return new TutorialHolder(itemView);
    }

    @Override
    public void onBindViewHolder(TutorialHolder holder, int position) {
        holder.text.setText("Position :"+position);
        if(position %3 == 0)
            holder.image.setBackgroundResource(R.drawable.harkidoon);
        if(position %3 == 1)
            holder.image.setBackgroundResource(R.drawable.harkidoon1);
        if(position %3 == 2)
            holder.image.setBackgroundResource(R.drawable.har_ki_dun8_1);

    }

    @Override
    public int getItemCount() {
        return 100;
    }


}
