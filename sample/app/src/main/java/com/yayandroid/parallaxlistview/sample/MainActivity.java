package com.yayandroid.parallaxlistview.sample;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;

import com.yayandroid.parallaxlistview.ParallaxListView;

/**
 * Created by yahyabayramoglu on 14/04/15.
 */
public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ParallaxListView parallaxListView = (ParallaxListView) findViewById(R.id.parallaxListView);
        parallaxListView.setDividerHeight(20);
        parallaxListView.setAdapter(new TestAdapter(this));
    }

}
