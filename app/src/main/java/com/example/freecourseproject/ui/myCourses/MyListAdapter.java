package com.example.freecourseproject.ui.myCourses;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.freecourseproject.R;

public class MyListAdapter extends RecyclerView.Adapter<MyListAdapter.ViewHolder> {
    private String[] titles;
    private String[] by;
    private String[] desc;
    public MyListAdapter(String[] titles, String[] by, String[] desc) {
        this.titles = titles;
        this.by = by;
        this.desc = desc;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.courses_list_item,parent,false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyListAdapter.ViewHolder holder, final int position) {
        holder.titles.setText(titles[position]);
        holder.byName.setText(by[position]);
        holder.desc.setText(desc[position]);
        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavController navController = Navigation.findNavController(v);
                Bundle bundle = new Bundle();
                bundle.putString("title", titles[position]);
                bundle.putString("by", by[position]);
                bundle.putString("desc", desc[position]);
                navController.navigate(R.id.action_navigation_myCourses_to_myCoursesContent, bundle);
            }
        });
    }

    @Override
    public int getItemCount() {
        return titles.length;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView titles;
        TextView byName;
        TextView desc;
        RelativeLayout relativeLayout;

        ViewHolder(View itemView) {
            super(itemView);
            this.titles = (TextView) itemView.findViewById(R.id.title);
            this.byName = (TextView) itemView.findViewById(R.id.byName);
            this.desc = (TextView) itemView.findViewById(R.id.desc);
            this.relativeLayout = (RelativeLayout) itemView.findViewById(R.id.relativeLayout);
        }
    }
}
