package com.simon.hidebar;

import android.support.v7.widget.RecyclerView;

/**
 * Created by Administrator on 2016-05-26 0026.
 */
public abstract class RecycleScrollListener extends RecyclerView.OnScrollListener {

    private final static int MIN_HIGHT = 20;
    private int scrollDistance;
    private boolean isShow = true;

    public abstract void onHidden();

    public abstract void onShow();

    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);
        if (scrollDistance > MIN_HIGHT && isShow) {
            onHidden();
            isShow = false;
            scrollDistance = 0;
        } else if (scrollDistance < -MIN_HIGHT && !isShow) {
            onShow();
            isShow = true;
            scrollDistance = 0;
        }

        if ((dy > 0 && isShow) || (dy < 0 && !isShow)) {
            scrollDistance += dy;
        }
    }
}
