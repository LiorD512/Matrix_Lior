package com.liordahan.matrix_lior.view_models;

import android.content.Context;
import android.util.JsonReader;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;


import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.liordahan.matrix_lior.models.Benefit;
import com.liordahan.matrix_lior.models.Categories;
import com.liordahan.matrix_lior.models.DataListAddr;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BenefitListViewModel extends EnvironmentViewModel {

    private static final String TAG = BenefitListViewModel.class.getSimpleName();

    private MutableLiveData<List<Categories>> mBenefits;


    public BenefitListViewModel() {
        mBenefits = new MutableLiveData<>();
    }

    public LiveData<List<Categories>> getBenefits(Context context) {
        ArrayList<Categories> benefitArrayList = getRepository().benefitRepo().getClientBenefits(context);
        mBenefits.postValue(benefitArrayList);
        return mBenefits;
    }


    public static class BenefitListViewModelFactory implements ViewModelProvider.Factory {

        public BenefitListViewModelFactory() {
        }

        @NonNull
        @Override
        public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
            //noinspection unchecked
            return (T) new BenefitListViewModel();
        }
    }

}
