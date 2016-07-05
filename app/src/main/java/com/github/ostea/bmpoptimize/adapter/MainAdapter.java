package com.github.ostea.bmpoptimize.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.github.ostea.bmpoptimize.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Desc:
 * Created by Thorn on 16/7/5.
 */
public class MainAdapter extends BaseAdapter {

    List<String> mList = new ArrayList<>();
    Context mContext;

    public MainAdapter(Context mContext, List<String> mList) {
        this.mContext = mContext;
        this.mList = mList;
    }

    public MainAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public void setData(List<String> mda) {
        mList.clear();
        mList.addAll(mda);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public String getItem(int i) {
        return mList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Holder holder;
        if (view == null) {
            view = LayoutInflater.from(mContext).inflate(R.layout.item_main, null);
            holder = new Holder(view);
            view.setTag(holder);
        } else {
            holder = (Holder) view.getTag();
        }
        holder.bindData(getItem(i));
        return view;
    }

    class Holder {
        TextView mTitle;

        public Holder(View view) {
            mTitle = (TextView) view.findViewById(R.id.tv_title);
        }

        public void bindData(String title) {
            mTitle.setText(title);
        }
    }
}
