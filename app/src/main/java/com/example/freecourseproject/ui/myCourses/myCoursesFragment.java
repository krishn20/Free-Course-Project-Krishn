package com.example.freecourseproject.ui.myCourses;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.freecourseproject.R;

public class myCoursesFragment extends Fragment {

    private myCoursesViewModel myCoursesViewModel;
    String[] titles = {"App Development","Web Development","Machine Learning","App Development","Game Development"};
    String[] by = {"Krishn Agarwal","Prakhar Mathur","Deeptanshu Sharma","Ajay Kumar","Kartik Ahluwalia"};
    String[] desc = {"This is a course on App Development","This is a course on Web Development","This is a course on Machine Learning","This is a course on App Development","This is a course on Game Development"};

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        myCoursesViewModel =
                ViewModelProviders.of(this).get(myCoursesViewModel.class);
        View root = inflater.inflate(R.layout.fragment_courses, container, false);
        final TextView textView = root.findViewById(R.id.text_courses);
        final RecyclerView recyclerView = root.findViewById(R.id.recyclerView);
        MyListAdapter myListAdapter = new MyListAdapter(titles,by,desc);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(myListAdapter);


        myCoursesViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}
