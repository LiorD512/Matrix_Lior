package com.liordahan.matrix_lior.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.liordahan.matrix_lior.R;
import com.liordahan.matrix_lior.interfaces.OnListItemClickListener;
import com.liordahan.matrix_lior.models.Categories;
import com.liordahan.matrix_lior.utils.BaseAdapter;
import com.liordahan.matrix_lior.utils.BaseHolder;

import butterknife.BindView;

public class CategoriesAdapter extends BaseAdapter<Categories, CategoriesAdapter.CategoriesViewHolder> {

    private final Context context;
    private OnListItemClickListener onBenefitItemClickListener;

    public CategoriesAdapter(Context context,OnListItemClickListener onBenefitItemClickListener) {
        this.context = context;
        this.onBenefitItemClickListener = onBenefitItemClickListener;
    }


    @NonNull
    @Override
    public CategoriesAdapter.CategoriesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.categories_item_layout, parent, false);
        return new CategoriesAdapter.CategoriesViewHolder(
                layout
        );
    }

    class CategoriesViewHolder extends BaseHolder<Categories> {

        @BindView(R.id.tvSubjectName)
        TextView categoryTitle;
        @BindView(R.id.rvChapters)
        RecyclerView benefitsList;


        CategoriesViewHolder(View itemView) {
            super(itemView);
        }


        @Override
        protected void fillViews(final Categories categories) {
            categoryTitle.setText(categories.getTitle());

            benefitsList.setAdapter(new BenefitListAdapter(context, categories.getBenefitList(), onBenefitItemClickListener));
            benefitsList.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
            benefitsList.setHasFixedSize(true);

            PagerSnapHelper snapHelper = new PagerSnapHelper();
            snapHelper.attachToRecyclerView(benefitsList);


        }

    }
}
