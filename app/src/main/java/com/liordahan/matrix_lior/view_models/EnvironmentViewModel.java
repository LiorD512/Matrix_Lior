package com.liordahan.matrix_lior.view_models;

import androidx.lifecycle.ViewModel;

import com.liordahan.matrix_lior.base.Environment;
import com.liordahan.matrix_lior.repository.BaseRepository;


public class EnvironmentViewModel extends ViewModel {

    protected <T extends BaseRepository> T getRepository() {
        return (T) Environment.repository();
    }

}
