package com.liordahan.matrix_lior.view;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.liordahan.matrix_lior.R;
import com.liordahan.matrix_lior.adapters.BenefitListAdapter;
import com.liordahan.matrix_lior.adapters.CategoriesAdapter;
import com.liordahan.matrix_lior.constants.Constants;
import com.liordahan.matrix_lior.interfaces.OnListItemClickListener;
import com.liordahan.matrix_lior.models.Benefit;
import com.liordahan.matrix_lior.models.Categories;
import com.liordahan.matrix_lior.utils.BaseFragment;
import com.liordahan.matrix_lior.utils.ViewHolder;
import com.liordahan.matrix_lior.view_models.BenefitListViewModel;

import java.util.List;
import java.util.Objects;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class BenefitListFragment extends BaseFragment implements OnListItemClickListener {


    private Holder holder;
    private BenefitListViewModel viewModel;




    @Override
    public String getManagerTag() {
        return BenefitListFragment.class.getSimpleName();
    }

    public BenefitListFragment() {
        // Required empty public constructor
    }

    public static BenefitListFragment newInstance(){
        return new BenefitListFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v =  inflater.inflate(R.layout.fragment_benefit_list, container, false);

        holder = new Holder(v);
        // Inflate the layout for this fragment
        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewModel = ViewModelProviders
                .of(this, new BenefitListViewModel.BenefitListViewModelFactory())
                .get(BenefitListViewModel.class);


        viewModel.getBenefits(getContext()).observe(getViewLifecycleOwner(), new Observer<List<Categories>>() {
            @Override
            public void onChanged(List<Categories> benefits) {
                holder.publishData(benefits);
            }
        });

    }

    @Override
    public void OnListItemClickListener(Benefit benefit) {
        showFragment(BenefitDataFragment.newInstance(benefit.getCatId(), benefit.getId(), benefit.getImag()), true, false);
    }


    class Holder extends ViewHolder {

        @BindView(R.id.benefit_list_rv)
        RecyclerView benefitList;

        Holder(View view) {
            super(view);
            setupList();
        }


        private void setupList() {

            final CategoriesAdapter adapter = new CategoriesAdapter(getContext(), BenefitListFragment.this::OnListItemClickListener);

            benefitList.setAdapter(adapter);
            benefitList.setLayoutManager(new LinearLayoutManager(getContext()));
        }


        void publishData(List<Categories> result) {
            if (result == null) {
                ((CategoriesAdapter) holder.benefitList.getAdapter()).setData(null);
            }else {
                if (!Objects.equals(((CategoriesAdapter) holder.benefitList.getAdapter()).getData(), result)) {
                    ((CategoriesAdapter) holder.benefitList.getAdapter()).setData(result);
                    (holder.benefitList.getAdapter()).notifyDataSetChanged();

                }
            }

        }


    }
}
