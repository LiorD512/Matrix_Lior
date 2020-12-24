package com.liordahan.matrix_lior;

import android.app.Application;

import com.liordahan.matrix_lior.base.Environment;
import com.liordahan.matrix_lior.repository.MaxRepository;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();



        final MaxRepository repository = new MaxRepository();

        Environment.installRepository(repository);


    }


}
