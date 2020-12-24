package com.liordahan.matrix_lior.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;
import com.liordahan.matrix_lior.R;
import com.liordahan.matrix_lior.adapters.BenefitListAdapter;
import com.liordahan.matrix_lior.adapters.ViewPagerAdapter;
import com.liordahan.matrix_lior.models.Benefit;
import com.liordahan.matrix_lior.utils.BaseFragment;
import com.liordahan.matrix_lior.utils.SwipeDisabledViewPager;
import com.liordahan.matrix_lior.utils.ViewHolder;
import com.liordahan.matrix_lior.view_models.BenefitListViewModel;

import java.util.List;
import java.util.Objects;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MainFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MainFragment extends BaseFragment {


    private Holder holder;



    @Override
    public String getManagerTag() {
        return MainFragment.class.getSimpleName();
    }

    public MainFragment() {
        // Required empty public constructor
    }

    public static MainFragment newInstance(){
        return new MainFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v =  inflater.inflate(R.layout.fragment_main, container, false);

        holder = new Holder(v);
        // Inflate the layout for this fragment
        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }


    class Holder extends ViewHolder {

        @BindView(R.id.viewPager)
        SwipeDisabledViewPager viewPager;
        @BindView(R.id.tabLayout)
        TabLayout tabLayout;


        Holder(View view) {
            super(view);

            addTabs(viewPager);
            tabLayout.setupWithViewPager(viewPager);


        }

        private void addTabs(ViewPager viewPager) {
            ViewPagerAdapter adapter = new ViewPagerAdapter(getChildFragmentManager());
            adapter.addFrag(BenefitListFragment.newInstance(), "כל ההטבות");
            adapter.addFrag(BenefitListFragment.newInstance(), "המומלצים");
            adapter.addFrag(MyTreatsFragment.newInstance(), "הפינוקים שלי");
            adapter.addFrag(FavoritesFragment.newInstance(), "המועדפים");
            viewPager.setAdapter(adapter);
        }


    }
}