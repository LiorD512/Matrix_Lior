package com.liordahan.matrix_lior.utils;


public class AssertUtils {

    public static void assertNotNull(Object object) {
        if(object == null) throw new IllegalArgumentException("Can not be null");
    }
}
