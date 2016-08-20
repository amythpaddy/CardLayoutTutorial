package com.caragiz_studioz.cardlayouttutorial;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.transition.ChangeImageTransform;
import android.transition.Explode;
import android.view.Window;
import android.widget.ImageView;

/**
 * Created by caragiz on 17-08-2016.
 */
public class DetailedCardActivity extends Activity {

    ImageView image;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        /*getWindow().setExitTransition(new Explode());
        getWindow().setEnterTransition(new Explode());
        getWindow().setSharedElementEnterTransition(new ChangeImageTransform());
        getWindow().setSharedElementExitTransition(new ChangeImageTransform());
        */setContentView(R.layout.detailedcardlayout);

        image = (ImageView)findViewById(R.id.info_img);
        if(SharedResorce.position %3 == 0)
            image.setBackgroundResource(R.drawable.harkidoon);
        if(SharedResorce.position %3 == 1)
            image.setBackgroundResource(R.drawable.harkidoon1);
        if(SharedResorce.position %3 == 2)
            image.setBackgroundResource(R.drawable.har_ki_dun8_1);

    }
}
