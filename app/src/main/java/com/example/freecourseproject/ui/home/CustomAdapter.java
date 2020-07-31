package com.example.freecourseproject.ui.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.freecourseproject.R;

public class CustomAdapter extends BaseAdapter {
    private int[] logos;
    private String[] titles;
    private String[] by;
    private String[] desc;
    private LayoutInflater layoutInflater;
    CustomAdapter(Context applicationContext, int[] logos, String[] titles, String[] by, String[] desc) {
        this.logos = logos;
        this.titles = titles;
        this.by = by;
        this.desc = desc;
        layoutInflater = (LayoutInflater.from(applicationContext));
    }

    @Override
    public int getCount() {
        return logos.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public static class Holder{
        ImageView img;
        TextView title;
        TextView by;
        TextView desc;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder = new Holder();
        View rowView;
        rowView = layoutInflater.inflate(R.layout.home_gridview, null);
        holder.img = rowView.findViewById(R.id.icon);
        holder.img.setImageResource(logos[position]);
        holder.title = rowView.findViewById(R.id.title);
        holder.title.setText(titles[position]);
        holder.by = rowView.findViewById(R.id.by);
        holder.by.setText(by[position]);
        holder.desc = rowView.findViewById(R.id.description);
        holder.desc.setText(desc[position]);
        return rowView;
    }
}
