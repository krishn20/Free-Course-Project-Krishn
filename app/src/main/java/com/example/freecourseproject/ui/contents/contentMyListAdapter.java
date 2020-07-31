package com.example.freecourseproject.ui.contents;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;

import androidx.recyclerview.widget.RecyclerView;

import com.example.freecourseproject.R;

public class contentMyListAdapter extends RecyclerView.Adapter<contentMyListAdapter.ViewHolder> {
    private String[] links;
    private int[] images;
    public contentMyListAdapter(String[] links, int[] images) {
        this.links = links;
        this.images = images;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.content_list_item,parent,false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull contentMyListAdapter.ViewHolder holder, final int position) {
        holder.links.setText(links[position]);
        holder.images.setImageResource(images[position]);
        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserin = new Intent(Intent.ACTION_VIEW);
                browserin.setData(Uri.parse(links[position]));
                v.getContext().startActivity(browserin);
            }
        });
    }

    @Override
    public int getItemCount() {
        return links.length;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView links;
        ImageView images;
        RelativeLayout relativeLayout;

        ViewHolder(View itemView) {
            super(itemView);
            this.links = (TextView) itemView.findViewById(R.id.link);
            this.images = (ImageView) itemView.findViewById(R.id.image);
            this.relativeLayout = (RelativeLayout) itemView.findViewById(R.id.relativeLayout);
        }
    }
}

