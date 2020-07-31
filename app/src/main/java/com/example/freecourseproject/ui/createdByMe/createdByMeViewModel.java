package com.example.freecourseproject.ui.createdByMe;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class createdByMeViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public createdByMeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Create your own Course");
    }

    public LiveData<String> getText() {
        return mText;
    }
}