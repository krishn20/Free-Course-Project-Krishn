package com.example.freecourseproject.ui.contents;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.freecourseproject.R;

public class myCoursesContentViewModel extends ViewModel {

    private MutableLiveData<int[]> mImages;
    private MutableLiveData<String[]> mLinks;

    public myCoursesContentViewModel() {

        mImages = new MutableLiveData<>();
        mImages.setValue(new int[]{R.drawable.sunset_blue, R.drawable.sunset_green, R.drawable.sunset_red});

        mLinks = new MutableLiveData<>();
        mLinks.setValue(new String[]{"https://www.youtube.com/watch?v=akuONx5RTy8", "https://developer.android.com", "https://medium.com/@jordanjoz/12-android-blogs-you-should-be-following-1220c7e5398d"});
    }

    public LiveData<int[]> getImage() {
        return mImages;
    }

    public LiveData<String[]> getText() {
        return mLinks;
    }


}
