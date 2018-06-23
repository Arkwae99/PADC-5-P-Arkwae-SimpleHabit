package com.padcmyanmar.simplehabit.viewholders;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

import com.padcmyanmar.simplehabit.R;
import com.padcmyanmar.simplehabit.adapters.ProgramAdapter;
import com.padcmyanmar.simplehabit.data.vo.CategoriesVO;
import com.padcmyanmar.simplehabit.delegates.CategoryProgramDelegate;

public class CategoryViewHolder extends BaseViewHolder<CategoriesVO> {
    @BindView(R.id.rv_category_items)
    RecyclerView recyclerView;

    @BindView(R.id.tv_category_title)
    TextView tvCategoryTitle;

    private CategoryProgramDelegate mCategoryProgramDelegate;
    private ProgramAdapter programAdapter;

    public CategoryViewHolder(View itemView, CategoryProgramDelegate delegate) {
        super(itemView);

        ButterKnife.bind(this, itemView);
        mCategoryProgramDelegate = delegate;

        programAdapter = new ProgramAdapter(itemView.getContext(), mCategoryProgramDelegate);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(itemView.getContext()
                , LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(programAdapter);

    }

    @Override
    public void setData(CategoriesVO data) {
        tvCategoryTitle.setText(data.getTitle());
        programAdapter.setNewData(data.getPrograms());
        programAdapter.setCategory(data);
    }


    @Override
    public void onClick(View v) {

    }
}
