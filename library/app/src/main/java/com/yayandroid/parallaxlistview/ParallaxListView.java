package com.yayandroid.parallaxlistview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.AbsListView;
import android.widget.ListView;

/**
 * Created by yahyabayramoglu on 14/04/15.
 */
public class ParallaxListView extends ListView {

    private OnScrollListener scrollListener;

    public ParallaxListView(Context context) {
        super(context);
        init();
    }

    public ParallaxListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ParallaxListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        setOnScrollListener(defaultListener);
    }

    private OnScrollListener defaultListener = new OnScrollListener() {
        @Override
        public void onScrollStateChanged(AbsListView view, int scrollState) {
            if (scrollListener != null)
                scrollListener.onScrollStateChanged(view, scrollState);
        }

        @Override
        public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

            for (int i = 0; i < view.getChildCount(); i++) {
                ((ParallaxViewHolder) view.getChildAt(i).getTag()).animateImage();
            }

            if (scrollListener != null)
                scrollListener.onScroll(view, firstVisibleItem, visibleItemCount, totalItemCount);
        }
    };

    @Override
    public void setOnScrollListener(OnScrollListener listener) {
        if (listener != defaultListener)
            scrollListener = listener;
        else
            super.setOnScrollListener(listener);
    }
}
