package com.caragiz_studioz.cardlayouttutorial;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.ChangeImageTransform;
import android.transition.Explode;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.ListView;

public class MainActivity extends Activity {

    ImageView sharedImg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        /*getWindow().setExitTransition(new Explode());
        getWindow().setEnterTransition(new Explode());
        getWindow().setSharedElementEnterTransition(new ChangeImageTransform());
        getWindow().setSharedElementExitTransition(new ChangeImageTransform());
        */setContentView(R.layout.activity_main);

        /*ListView listView = (ListView)findViewById(R.id.list_item);
        Resources resource = getResources();
        listView.setAdapter(new ListAdapter(this , resource));*/

        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.cardList);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(new RecycleViewAdapter());
        recyclerView.addOnItemTouchListener(new OnClickListener(this , sharedImg));
    }

    public  void newActivity(View view){
        Intent intent = new Intent(this , DetailedCardActivity.class);
        startActivity(intent);
    }
}
