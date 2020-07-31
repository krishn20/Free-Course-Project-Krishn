package com.example.freecourseproject.ui.home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.freecourseproject.R;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    String[] titles = {"App Development","Web Development","Machine Learning","App Development","Game Development","App Development","Web Development","Machine Learning","App Development","Game Development","App Development","Web Development","Machine Learning","App Development","Game Development"};
    String[] by = {"Krishn Agarwal","Prakhar Mathur","Deeptanshu Sharma","Ajay Kumar","Kartik Ahluwalia","Krishn Agarwal","Prakhar Mathur","Deeptanshu Sharma","Ajay Kumar","Kartik Ahluwalia","Krishn Agarwal","Prakhar Mathur","Deeptanshu Sharma","Ajay Kumar","Kartik Ahluwalia"};
    String[] desc = {"This is a course on App Development","This is a course on Web Development","This is a course on Machine Learning","This is a course on App Development","This is a course on Game Development","This is a course on App Development","This is a course on Web Development","This is a course on Machine Learning","This is a course on App Development","This is a course on Game Development","This is a course on App Development","This is a course on Web Development","This is a course on Machine Learning","This is a course on App Development","This is a course on Game Development"};
    int[] logos = {R.drawable.sunset_blue,R.drawable.sunset_red,R.drawable.sunset_yellow,R.drawable.sunset_green,R.drawable.sunset_orange,R.drawable.oneplus_wallp,R.drawable.sunset_violet,R.drawable.oneplus_wallp_mobile, R.drawable.sunset_blue,R.drawable.sunset_red,R.drawable.sunset_yellow,R.drawable.sunset_green,R.drawable.sunset_orange,R.drawable.oneplus_wallp,R.drawable.sunset_violet};

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        final TextView textView = root.findViewById(R.id.text_home);
        final GridView gridView = root.findViewById(R.id.gridView);
        CustomAdapter customAdapter = new CustomAdapter(getContext(),logos,titles,by,desc);
        gridView.setAdapter(customAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                NavController navController = Navigation.findNavController(view);
                Bundle bundle = new Bundle();
                bundle.putString("title", titles[position]);
                bundle.putString("by", by[position]);
                bundle.putString("desc", desc[position]);
                navController.navigate(R.id.action_navigation_home_to_navigation_myCoursesContent, bundle);
            }
        });

        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}
