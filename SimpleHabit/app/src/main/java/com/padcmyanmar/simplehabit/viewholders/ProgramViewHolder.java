package com.padcmyanmar.simplehabit.viewholders;

import android.view.View;
import android.widget.TextView;

import com.padcmyanmar.simplehabit.R;
import com.padcmyanmar.simplehabit.data.vo.CategoriesVO;
import com.padcmyanmar.simplehabit.data.vo.ProgramsVO;
import com.padcmyanmar.simplehabit.delegates.CategoryProgramDelegate;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ProgramViewHolder extends BaseViewHolder<ProgramsVO> {

    @BindView(R.id.tv_title)
    TextView tvTitle;

    @BindView(R.id.tv_duration)
    TextView tvDuration;

    private CategoryProgramDelegate mCategoryProgramDelegate;

    private CategoriesVO mCategoryVO;

    private ProgramsVO mProgram;


    public ProgramViewHolder(View itemView, CategoryProgramDelegate delegate) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        mCategoryProgramDelegate = delegate;
    }

    @Override
    public void setData(ProgramsVO data) {
        mProgram = data;
        tvTitle.setText(data.getTitle());


    }

    public void setCategory(CategoriesVO category){
        mCategoryVO = category;
    }

    @OnClick(R.id.cv_program)

    @Override
    public void onClick(View v) {
        mCategoryProgramDelegate.onTapCategoryProgramDelegate(mCategoryVO.getCategoryId(),mProgram.getProgramId());
    }
}
