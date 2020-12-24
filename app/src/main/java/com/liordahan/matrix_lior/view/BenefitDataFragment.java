package com.liordahan.matrix_lior.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.liordahan.matrix_lior.R;
import com.liordahan.matrix_lior.adapters.CategoriesAdapter;
import com.liordahan.matrix_lior.constants.Constants;
import com.liordahan.matrix_lior.models.Categories;
import com.liordahan.matrix_lior.utils.BaseFragment;
import com.liordahan.matrix_lior.utils.ViewHolder;
import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.ConcurrentNavigableMap;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BenefitDataFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BenefitDataFragment extends BaseFragment {

    private int benefitCatId;
    private String benefitElementId;
    private String benefitImg;

    private Holder holder;

    @Override
    public String getManagerTag() {
        return BenefitDataFragment.class.getSimpleName();
    }

    public BenefitDataFragment() {
        // Required empty public constructor
    }


    public static BenefitDataFragment newInstance(int benefitCatId, String benefitElementId, String benefitImg) {
        BenefitDataFragment fragment = new BenefitDataFragment();
        Bundle args = new Bundle();
        args.putInt(Constants.BENEFIT_CAT_ID, benefitCatId);
        args.putString(Constants.BENEFIT_ID, benefitElementId);
        args.putString(Constants.BENEFIT_IMAGE_URL, benefitImg);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            benefitCatId = getArguments().getInt(Constants.BENEFIT_CAT_ID);
            benefitElementId = getArguments().getString(Constants.BENEFIT_ID);
            benefitImg = getArguments().getString(Constants.BENEFIT_IMAGE_URL);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_benefit_data, container, false);

        holder = new Holder(v);

        // Inflate the layout for this fragment
        return v;
    }



    class Holder extends ViewHolder {

        @BindView(R.id.benefit_data_cat_id)
        TextView catId;
        @BindView(R.id.benefit_data_id)
        TextView benefitId;
        @BindView(R.id.benefit_data_img)
        ImageView image;

        Holder(View view) {
            super(view);
            catId.setText(String.valueOf(benefitCatId));
            benefitId.setText(benefitElementId);
            Picasso.get()
                    .load(benefitImg)
                    .error(R.drawable.p_holder)
                    .into(image);

        }





    }
}