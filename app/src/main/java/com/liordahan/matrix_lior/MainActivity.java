package com.liordahan.matrix_lior;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.liordahan.matrix_lior.utils.BaseFragment;
import com.liordahan.matrix_lior.utils.FragmentVisualizer;
import com.liordahan.matrix_lior.view.BenefitListFragment;
import com.liordahan.matrix_lior.view.MainFragment;

import java.util.Objects;

public class MainActivity extends AppCompatActivity implements FragmentVisualizer {

    private MainFragmentVisualizer mFragmentVisualizer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mFragmentVisualizer = new MainFragmentVisualizer();


        if (getSupportFragmentManager().findFragmentById(R.id.container) == null) {
            showFragment(MainFragment.newInstance(), false, false);
        }


    }


    @Override
    public void showFragment(BaseFragment frag, boolean toBackStack, boolean clearAll) {
        mFragmentVisualizer.showFragment(frag, toBackStack, clearAll);

    }

    @Override
    public void removeAllFragments() {
        mFragmentVisualizer.removeAllFragments();

    }

    class MainFragmentVisualizer implements FragmentVisualizer {

        @Override
        public void showFragment(BaseFragment frag, boolean toBackStack, boolean clearAll) {
            final FragmentManager fm = getSupportFragmentManager();

            final BaseFragment currentFragment = (BaseFragment) fm.findFragmentById(R.id.container);
            if (currentFragment != null && frag.getManagerTag().equals(currentFragment.getManagerTag())) { // if current visible fragment is same as requested
                return;
            }

            if (clearAll) {
                clearBackStack();
            }

            FragmentTransaction ft = fm.beginTransaction();
            if (fm.getBackStackEntryCount() > 0) {
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
            }
            ft.replace(R.id.container, frag, frag.getManagerTag());
            if (toBackStack) {
                ft.addToBackStack(frag.getManagerTag());
            }

            ft.commit();

        }

        @Override
        public void removeAllFragments() {
            clearBackStack();
        }


        void clearBackStack() {
            final FragmentManager fm = getSupportFragmentManager();

            //noinspection StatementWithEmptyBody
            while (fm.popBackStackImmediate(R.id.container, FragmentManager.POP_BACK_STACK_INCLUSIVE)) {
            }

            if (fm.findFragmentById(R.id.container) != null) {
                getSupportFragmentManager().beginTransaction()
                        .remove(Objects.requireNonNull(fm.findFragmentById(R.id.container)))
                        .commitNow();
            }
        }

    }
}
