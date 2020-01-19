package com.example.portrait;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class ColorAdapter extends BaseAdapter {
    Context context;
    int mList[];
    LayoutInflater inflter;
    public ColorAdapter(Context applicationContext, int[] mList) {
        this.context = applicationContext;
        this.mList = mList;
        inflter = (LayoutInflater.from(applicationContext));
    }
    @Override
    public int getCount() {
        return mList.length;
    }
    @Override
    public Object getItem(int i) {
        return null;
    }
    @Override
    public long getItemId(int i) {
        return 0;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflter.inflate(R.layout.activity_colorview, null); // inflate the layout
        ImageView icolor = (ImageView) view.findViewById(R.id.icolor); // get the reference of ImageView
        icolor.setImageResource(mList[i]); // set logo images
        return view;
    }
}
