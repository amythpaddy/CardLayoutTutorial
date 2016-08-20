package com.caragiz_studioz.cardlayouttutorial;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.graphics.Path;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by caragiz on 16-08-2016.
 */
public class OnClickListener implements RecyclerView.OnItemTouchListener {

    Activity activity;
    GestureDetector gestureDetector;
    ImageView sharedImage;

    public OnClickListener(MainActivity mainActivity , ImageView sharedImage) {
        activity = (Activity)mainActivity;
        this.sharedImage = sharedImage;
        gestureDetector = new GestureDetector(activity.getApplicationContext() , new GestureDetector.SimpleOnGestureListener(){

            @Override
            public boolean onSingleTapUp(MotionEvent e){
                return true;
            }
        });
    }

    void OnClickListener(Activity activity)
    {
        this.activity = activity;
    }
    @Override
    public void onTouchEvent(RecyclerView rv, MotionEvent e) {
        Toast.makeText(activity.getApplicationContext() , "touch" , Toast.LENGTH_SHORT).show();
        Intent intent = new Intent();
        String transitionName = activity.getString(R.string.imagepoint);
        Log.i("Touch","Received");
        /*ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(activity , transitionName);
        ActivityCompat.startActivity(activity , intent , options.toBundle());
*/
    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
        Toast.makeText(activity.getApplicationContext() , "Disallow touch" , Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
        if(gestureDetector.onTouchEvent(e))
        {
            Toast.makeText(activity.getApplicationContext() , "Intercept touch once" , Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(activity, DetailedCardActivity.class);
            SharedResorce.position = rv.getChildAdapterPosition(rv.findChildViewUnder(e.getX() , e.getY()));
            Log.i("shared element :",SharedResorce.sharedImage.toString());

            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(activity , SharedResorce.sharedImage , "sharedimage");

            Path path = new Path();
            path.lineTo(0.25f , 0.25f);
            path.moveTo(0.25f , 0.25f);
            path.lineTo(10f , 10f);
            path.moveTo(10f , 10f);
            ObjectAnimator animator = ObjectAnimator.ofFloat(SharedResorce.sharedImage , View.X , View.Y , path);

            animator.start();
            activity.startActivity(intent , options.toBundle());
            //activity.startActivity(intent);
        }

        return false;
    }
}
