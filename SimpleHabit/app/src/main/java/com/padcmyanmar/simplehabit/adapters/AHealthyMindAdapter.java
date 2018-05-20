package com.padcmyanmar.simplehabit.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.padcmyanmar.simplehabit.R;
import com.padcmyanmar.simplehabit.viewholders.AHealthyMindViewHolder;

/**
 * Created by Ag Phone Khant on 20/5/2018.
 */

public class AHealthyMindAdapter extends RecyclerView.Adapter<AHealthyMindViewHolder> {
    @Override
    public AHealthyMindViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View itemHealthyMind = layoutInflater.inflate(R.layout.item_a_healthy_mind, parent, false);
        AHealthyMindViewHolder healthyMindViewHolder = new AHealthyMindViewHolder(itemHealthyMind);
        return healthyMindViewHolder;
    }

    @Override
    public void onBindViewHolder(AHealthyMindViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 20;
    }
}
