package com.padcmyanmar.simplehabit.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.padcmyanmar.simplehabit.R;
import com.padcmyanmar.simplehabit.viewholders.AllTopicsViewHolder;

/**
 * Created by Ag Phone Khant on 20/5/2018.
 */

public class AllTopicsAdapter extends RecyclerView.Adapter<AllTopicsViewHolder> {
    @Override
    public AllTopicsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View itemAllTopices = layoutInflater.inflate(R.layout.item_all_topics, parent, false);
        AllTopicsViewHolder allTopicesViewHolder = new AllTopicsViewHolder(itemAllTopices);
        return allTopicesViewHolder;
    }

    @Override
    public void onBindViewHolder(AllTopicsViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 9;
    }
}
