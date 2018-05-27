package com.padcmyanmar.simplehabit.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.padcmyanmar.simplehabit.R;
import com.padcmyanmar.simplehabit.data.vo.CurrentProgramsVO;

import butterknife.BindView;
import butterknife.ButterKnife;

public class StartHereViewHolder extends BaseViewHolder<CurrentProgramsVO> {

    @BindView(R.id.iv_starthere)
    ImageView ivStartHere;

    @BindView(R.id.tv_start_here)
    TextView tvStartHere;

    @BindView(R.id.tv_time_start_here)
    TextView tvTimeStartHere;

    @BindView(R.id.btn_start)
    Button btnStart;

    public StartHereViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    @Override
    public void setData(CurrentProgramsVO data) {
        tvStartHere.setText(data.getTitle());
        tvTimeStartHere.setText(data.getAverageLengths().get(0)+" mins");
        btnStart.setText(data.getCurrentPeriod());

    }



    @Override
    public void onClick(View v) {

    }
}
