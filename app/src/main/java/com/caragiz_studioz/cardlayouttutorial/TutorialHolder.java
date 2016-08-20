package com.caragiz_studioz.cardlayouttutorial;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by caragiz on 12-08-2016.
 */
public class TutorialHolder extends RecyclerView.ViewHolder {
    protected TextView text;
    protected ImageView image;
    public TutorialHolder(View itemView) {
        super(itemView);
        text = (TextView)itemView.findViewById(R.id.info_text);
        image = (ImageView)itemView.findViewById(R.id.info_img);
        SharedResorce.sharedImage = image;
    }
}
