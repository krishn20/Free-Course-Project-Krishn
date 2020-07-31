package com.example.freecourseproject.ui.myCourses;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class myCoursesViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public myCoursesViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is My Courses fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}