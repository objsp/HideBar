package com.simon.hidebar;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Administrator on 2016-05-26 0026.
 */
public class RecycleViewAdapter extends RecyclerView.Adapter<MyHolder> {

    private List<String> list;
    private final static int TYPE_HEADER = 0;
    private final static int TYPE_ITEM = 1;

    public RecycleViewAdapter(List<String> list) {
        this.list = list;
    }

    @Override
    public int getItemCount() {
        return list.size() + 1;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_HEADER) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.header, parent, false);
            return new MyHolder(view);
        } else {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cart, parent, false);
            return new MyHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        if (position != TYPE_HEADER) {
            String str = list.get(position - 1);
            holder.tv.setText(str);
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return TYPE_HEADER;
        } else {
            return TYPE_ITEM;
        }
    }
}
