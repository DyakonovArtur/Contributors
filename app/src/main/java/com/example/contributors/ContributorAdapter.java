package com.example.contributors;
import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

class ContributorAdapter /*extends RecyclerView.Adapter<ContributorAdapter.ViewHolder>*/ {
/*
    private final static String PHOTO_URL = "http://services.hanselandpetal.com/photos/";
    private List<Contributor> mContributors;
    private Context mContext;

    ContributorAdapter(List<Contributor> contributor) {
        this.mContributors = contributor;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Contributor contributor = mContributors.get(position);
        holder.nameTextView.setText(contributor.getName());

        Picasso.with(mContext)
                .load(PHOTO_URL + flower.getPhoto())
                .resize(200, 150)
                .into(holder.flowerImageView);
    }

    @Override
    public int getItemCount() {
        if (mFlowers == null) {
            return 0;
        }
        return mFlowers.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView;
        ImageView flowerImageView;

        ViewHolder(View itemView) {
            super(itemView);
            nameTextView = (TextView) itemView.findViewById(R.id.nameTextView);
            flowerImageView = (ImageView) itemView.findViewById(R.id.itemImageView);
        }
    }*/
}