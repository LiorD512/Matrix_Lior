package com.liordahan.matrix_lior.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.liordahan.matrix_lior.R;
import com.liordahan.matrix_lior.interfaces.OnListItemClickListener;
import com.liordahan.matrix_lior.models.Benefit;
import com.liordahan.matrix_lior.utils.BaseAdapter;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class BenefitListAdapter extends RecyclerView.Adapter<BenefitListAdapter.CustomViewHolder> {



    private Context context;
    private ArrayList<Benefit> benefitArrayList;
    private LayoutInflater inflater;
    private OnListItemClickListener onListItemClickListener;

    public BenefitListAdapter(Context context, ArrayList<Benefit> benefitArrayList, OnListItemClickListener onListItemClickListener) {
        this.context = context;
        this.onListItemClickListener = onListItemClickListener;
        this.benefitArrayList = benefitArrayList;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        view = inflater.inflate(R.layout.benefit_item_layout, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        Benefit benefit = benefitArrayList.get(position);
        holder.benefitTitle.setText(benefit.getTitle());
        holder.benefitStitle.setText(benefit.getSTitle());
        Picasso.get()
                .load(benefit.getImag())
                .error(R.drawable.p_holder)
                .into(holder.benefitImage);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onListItemClickListener.OnListItemClickListener(benefit);
            }
        });
    }

    @Override
    public int getItemCount() {
        return benefitArrayList.size();
    }


    public class CustomViewHolder extends RecyclerView.ViewHolder {

        public ImageView benefitImage;
        public TextView benefitTitle;
        public TextView benefitStitle;

        public CustomViewHolder(View itemView) {
            super(itemView);
            benefitTitle = (TextView) itemView.findViewById(R.id.txt_benefit_title);
            benefitStitle = (TextView) itemView.findViewById(R.id.txt_benefit_stitle);
            benefitImage = (ImageView) itemView.findViewById(R.id.benefit_img);
        }
    }
}
