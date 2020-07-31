package com.example.freecourseproject.ui.myAccount;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class myAccountViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public myAccountViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Your Account - ");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
