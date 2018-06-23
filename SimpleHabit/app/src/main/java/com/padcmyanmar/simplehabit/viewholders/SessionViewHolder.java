package com.padcmyanmar.simplehabit.viewholders;

import android.view.View;
import android.widget.TextView;

import com.padcmyanmar.simplehabit.R;
import com.padcmyanmar.simplehabit.data.vo.SessionsVO;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by Ag Phone Khant on 2/6/2018.
 */

public class SessionViewHolder extends BaseViewHolder<SessionsVO> {

    @BindView(R.id.tv_number)
    TextView tvNumber;

    @BindView(R.id.tv_title_name)
    TextView tvTitleName;

    @BindView(R.id.detail_time)
    TextView tvDetailTime;


    public SessionViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    @Override
    public void setData(SessionsVO data) {
        tvNumber.setText(data.getSessionId());
        tvTitleName.setText(data.getTitle());
        String timeLength = data.getLengthInSeconds() / 60 + ":" + data.getLengthInSeconds() % 60;
        tvDetailTime.setText(timeLength);
    }

    @Override
    public void onClick(View v) {

    }
}
