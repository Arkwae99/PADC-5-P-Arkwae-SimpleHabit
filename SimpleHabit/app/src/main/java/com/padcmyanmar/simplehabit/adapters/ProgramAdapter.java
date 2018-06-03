package com.padcmyanmar.simplehabit.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;

import com.padcmyanmar.simplehabit.R;
import com.padcmyanmar.simplehabit.data.vo.CategoriesVO;
import com.padcmyanmar.simplehabit.data.vo.ProgramsVO;
import com.padcmyanmar.simplehabit.delegates.CategoryProgramDelegate;
import com.padcmyanmar.simplehabit.viewholders.ProgramViewHolder;


public class ProgramAdapter extends BaseRecyclerAdapter<ProgramViewHolder, ProgramsVO> {
    private CategoryProgramDelegate mCategoryProgramDelegate;

    private CategoriesVO mRootCategory;
    public ProgramAdapter(Context context, CategoryProgramDelegate delegate) {
        super(context);
        mCategoryProgramDelegate =delegate;
    }

    @NonNull
    @Override
    public ProgramViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mLayoutInflator.inflate(R.layout.item_category, parent, false);
        return new ProgramViewHolder(view, mCategoryProgramDelegate);
    }

    @Override
    public void onBindViewHolder(ProgramViewHolder holder, int position) {
        holder.setData(mData.get(position));
        holder.setCategory(mRootCategory);
    }

    public void setCategory(CategoriesVO category) {
        mRootCategory = category;
    }
}
