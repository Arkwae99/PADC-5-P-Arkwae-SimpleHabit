package com.padcmyanmar.simplehabit.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.padcmyanmar.simplehabit.R;
import com.padcmyanmar.simplehabit.data.vo.ProgramsVO;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ItemCategoryViewHolder extends BaseViewHolder<ProgramsVO> {

    @BindView(R.id.tv_title)
    TextView tvTitle;

    @BindView(R.id.tv_duration)
    TextView tvDuration;

        public ItemCategoryViewHolder(View itemView) {
        super(itemView);
            ButterKnife.bind(this, itemView);
    }

    @Override
    public void setData(ProgramsVO data) {
        tvTitle.setText(data.getTitle());
        tvDuration.setText( data.getAverageLengths().get(0)+ " mins");

    }

    @Override
    public void onClick(View v) {

    }
}
