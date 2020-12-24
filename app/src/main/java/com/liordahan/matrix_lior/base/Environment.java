package com.liordahan.matrix_lior.base;


import com.liordahan.matrix_lior.repository.BaseRepository;
import com.liordahan.matrix_lior.utils.AssertUtils;

public class Environment {

    private static volatile Environment INSTANCE;

    public static Environment instance() {
        if(INSTANCE == null) {
            synchronized (Environment.class) {
                if(INSTANCE == null) {
                    INSTANCE = new Environment();
                }
            }
        }

        return INSTANCE;
    }



    private BaseRepository repository;

    private Environment() {
    }


    public static BaseRepository repository() {
        return instance().repository;
    }


    public static void installRepository(BaseRepository repository) {
        AssertUtils.assertNotNull(repository);
        instance().repository = repository;
    }

}
