package com.padcmyanmar.simplehabit.viewholders;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import com.padcmyanmar.simplehabit.R;
import com.padcmyanmar.simplehabit.adapters.ItemInCategoryAdapter;
import com.padcmyanmar.simplehabit.data.vo.CategoriesVO;

public class CategoryViewHolder extends BaseViewHolder<CategoriesVO> {
    @BindView(R.id.rv_category_items)
    RecyclerView recyclerView;

    @BindView(R.id.tv_category_title)
    TextView tvCategoryTitle;


    ItemInCategoryAdapter itemInCategoryAdapter;
    public CategoryViewHolder(View itemView) {
        super(itemView);

        ButterKnife.bind(this,itemView);

        itemInCategoryAdapter= new ItemInCategoryAdapter(itemView.getContext());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(itemView.getContext()
                ,LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(itemInCategoryAdapter);

    }

    @Override
    public void setData(CategoriesVO data) {
        itemInCategoryAdapter.setNewData(data.getPrograms());
        tvCategoryTitle.setText(data.getTitle());
    }


    @Override
    public void onClick(View v) {

    }
}
