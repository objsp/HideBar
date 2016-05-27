package com.simon.hidebar;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Administrator on 2016-05-26 0026.
 */
public class MyHolder extends RecyclerView.ViewHolder {

    public TextView tv;

    public MyHolder(View itemView) {
        super(itemView);
        this.tv = (TextView) itemView.findViewById(R.id.tv);
    }
}
