package com.padcmyanmar.simplehabit.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.padcmyanmar.simplehabit.R;
import com.padcmyanmar.simplehabit.viewholders.MostPopularViewHolder;

/**
 * Created by Ag Phone Khant on 20/5/2018.
 */

public class MostPopularAdapter extends RecyclerView.Adapter<MostPopularViewHolder> {
    @Override
    public MostPopularViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View itemMostPopular = layoutInflater.inflate(R.layout.item_most_popular, parent, false);
        MostPopularViewHolder mostPopularViewHolder = new MostPopularViewHolder(itemMostPopular);
        return mostPopularViewHolder;
    }

    @Override
    public void onBindViewHolder(MostPopularViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 20;
    }
}
