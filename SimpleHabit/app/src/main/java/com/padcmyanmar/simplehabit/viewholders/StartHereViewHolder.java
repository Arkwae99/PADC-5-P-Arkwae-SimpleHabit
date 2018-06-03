package com.padcmyanmar.simplehabit.viewholders;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.padcmyanmar.simplehabit.R;
import com.padcmyanmar.simplehabit.data.vo.CurrentProgramsVO;
import com.padcmyanmar.simplehabit.delegates.CurrentProgramDelegate;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class StartHereViewHolder extends BaseViewHolder<CurrentProgramsVO> {

    @BindView(R.id.iv_starthere)
    ImageView ivStartHere;

    @BindView(R.id.tv_start_here)
    TextView tvStartHere;

    @BindView(R.id.tv_time_start_here)
    TextView tvTimeStartHere;

    @BindView(R.id.btn_start)
    Button btnStart;

    private CurrentProgramsVO mCurrentProgramVO;

    private CurrentProgramDelegate mCurrentProgramDelegate;

    public StartHereViewHolder(View itemView,CurrentProgramDelegate delegate) {
        super(itemView);
        ButterKnife.bind(this, itemView);

        mCurrentProgramDelegate = delegate;

    }

    @Override
    public void setData(CurrentProgramsVO data) {
        mCurrentProgramVO = data;
        tvStartHere.setText(data.getTitle());
        int[] averageLength = data.getAverageLength();
        tvTimeStartHere.setText(averageLength[0]+" mins");
        btnStart.setText(data.getCurrentPeriod());

    }

    @OnClick(R.id.cv_series)

    @Override
    public void onClick(View v) {
        mCurrentProgramDelegate.onTapCurrentProgram();
    }
}
