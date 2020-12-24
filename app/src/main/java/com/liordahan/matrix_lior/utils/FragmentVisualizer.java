package com.liordahan.matrix_lior.utils;


public interface FragmentVisualizer {

    void showFragment(BaseFragment frag, boolean toBackStack, boolean clearAll);

    void removeAllFragments();
}
