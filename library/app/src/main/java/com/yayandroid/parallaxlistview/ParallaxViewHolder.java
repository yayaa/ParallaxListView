package com.yayandroid.parallaxlistview;

import android.view.View;
import android.widget.ListView;

/**
 * Created by yahyabayramoglu on 14/04/15.
 */
public abstract class ParallaxViewHolder implements ParallaxImageView.ParallaxImageListener {

    public View itemView;
    private ParallaxImageView backgroundImage;

    public void setBackgroundImage(ParallaxImageView backgroundImage) {
        this.backgroundImage = backgroundImage;
        this.backgroundImage.setListener(this);
    }

    public ParallaxImageView getBackgroundImage() {
        return backgroundImage;
    }

    @Override
    public int[] requireValuesForTranslate() {
        int[] itemPosition = new int[2];
        itemView.getLocationOnScreen(itemPosition);

        int[] recyclerPosition = new int[2];
        ((ListView) itemView.getParent()).getLocationOnScreen(recyclerPosition);

        return new int[]{itemView.getMeasuredHeight(), itemPosition[1], ((ListView) itemView.getParent()).getMeasuredHeight(), recyclerPosition[1]};
    }

    public void animateImage() {
        getBackgroundImage().doTranslate();
    }

}
