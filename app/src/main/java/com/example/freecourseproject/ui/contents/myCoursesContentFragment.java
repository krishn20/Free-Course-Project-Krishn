package com.example.freecourseproject.ui.contents;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.freecourseproject.R;

public class myCoursesContentFragment extends Fragment {

    private myCoursesContentViewModel myCoursesContentViewModel;
    private String[] links = {};
    private int[] images = {};

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        myCoursesContentViewModel = ViewModelProviders.of(this).get(myCoursesContentViewModel.class);
        View root =  inflater.inflate(R.layout.my_courses_content_fragment, container, false);
        final TextView title = root.findViewById(R.id.title);
        title.setText(getArguments().getString("title"));
        final TextView by = root.findViewById(R.id.byName);
        by.setText(getArguments().getString("by"));
        final TextView desc = root.findViewById(R.id.desc);
        desc.setText(getArguments().getString("desc"));

        final RecyclerView recyclerView = root.findViewById(R.id.recyclerView);
        contentMyListAdapter myListAdapter = new contentMyListAdapter(links,images);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(myListAdapter);

        Button enroll = root.findViewById(R.id.enrollButton);
        enroll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "You have been enrolled! Check your \"My Courses\" list.", Toast.LENGTH_SHORT).show();
            }
        });


        myCoursesContentViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String[]>() {
            @Override
            public void onChanged(@Nullable String[] s) {
                links = s;
                contentMyListAdapter myListAdapter = new contentMyListAdapter(links,images);
                recyclerView.setHasFixedSize(true);
                recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                recyclerView.setAdapter(myListAdapter);
            }
        });

        myCoursesContentViewModel.getImage().observe(getViewLifecycleOwner(), new Observer<int[]>() {
            @Override
            public void onChanged(int[] ints) {
                images = ints;
                contentMyListAdapter myListAdapter = new contentMyListAdapter(links,images);
                recyclerView.setHasFixedSize(true);
                recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                recyclerView.setAdapter(myListAdapter);
            }
        });

        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        myCoursesContentViewModel = ViewModelProviders.of(this).get(myCoursesContentViewModel.class);
    }

}
