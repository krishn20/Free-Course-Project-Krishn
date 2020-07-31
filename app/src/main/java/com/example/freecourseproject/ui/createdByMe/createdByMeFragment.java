package com.example.freecourseproject.ui.createdByMe;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.freecourseproject.R;

public class createdByMeFragment extends Fragment {

    String[] titles = {"App Development","Web Development","Machine Learning","App Development","Game Development"};
    String[] by = {"Krishn Agarwal","Prakhar Mathur","Deeptanshu Sharma","Ajay Kumar","Kartik Ahluwalia"};
    String[] desc = {"This is a course on App Development","This is a course on Web Development","This is a course on Machine Learning","This is a course on App Development","This is a course on Game Development"};

    private createdByMeViewModel notificationsViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        notificationsViewModel =
                ViewModelProviders.of(this).get(createdByMeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_created, container, false);

        final TextView textView = root.findViewById(R.id.text_created);
        final RecyclerView recyclerView = root.findViewById(R.id.recyclerView);
        createdMyListAdapter createdMyListAdapter = new createdMyListAdapter(titles,by,desc);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(createdMyListAdapter);

        notificationsViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final EditText categoryInput = view.findViewById(R.id.categoryInput);
        final String category = categoryInput.getText().toString();

        final EditText titleInput = view.findViewById(R.id.titleInput);
        final String title = titleInput.getText().toString();

        final EditText descInput = view.findViewById(R.id.descInput);
        final String description = descInput.getText().toString();

        final EditText linkInput = view.findViewById(R.id.linkInput);
        final String link = linkInput.getText().toString();

        final EditText nameInput = view.findViewById(R.id.nameInput);
        final String name = nameInput.getText().toString();

        Button create = view.findViewById(R.id.createButton);
        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Course Created! Refresh the page to see it.", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
