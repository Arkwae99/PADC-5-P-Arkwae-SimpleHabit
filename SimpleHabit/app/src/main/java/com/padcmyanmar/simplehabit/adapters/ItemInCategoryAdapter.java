package com.padcmyanmar.simplehabit.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;

import com.padcmyanmar.simplehabit.R;
import com.padcmyanmar.simplehabit.data.vo.ProgramsVO;
import com.padcmyanmar.simplehabit.viewholders.CategoryViewHolder;
import com.padcmyanmar.simplehabit.viewholders.ItemCategoryViewHolder;


public class ItemInCategoryAdapter extends BaseRecyclerAdapter<ItemCategoryViewHolder, ProgramsVO> {
    public ItemInCategoryAdapter(Context context) {
        super(context);
    }

    @NonNull
    @Override
    public ItemCategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View categoryItemView = mLayoutInflator.inflate(R.layout.item_category, parent, false);
        return new ItemCategoryViewHolder(categoryItemView);
    }


}
