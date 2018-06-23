package com.padcmyanmar.simplehabit.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.padcmyanmar.simplehabit.R;
import com.padcmyanmar.simplehabit.data.vo.TopicsVO;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ItemInTopicViewHolder extends BaseViewHolder<TopicsVO> {
    @BindView(R.id.tv_topic_name)
    TextView tvTopicpName;

    @BindView(R.id.tv_topic_desc)
    TextView tvTopicDesc;

    @BindView(R.id.iv_topic_type)
    ImageView ivTopicType;

    @BindView(R.id.iv_topic)
    ImageView ivTopic;


    public ItemInTopicViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    @Override
    public void setData(TopicsVO data) {
        tvTopicpName.setText(data.getTopicName());
        tvTopicDesc.setText(data.getTopicDesc());

//        if(data.getBackground()!= null){
//            ivTopicType.setVisibility(View.VISIBLE);
//            Glide.with(ivTopicType.getContext())
//                    .load(data.getBackground())
//                    .into(ivTopicType);
//        }else {
//            ivTopicType.setVisibility(View.GONE);
//        }
//
//        if(data.getBackground()!= null){
//            ivTopic.setVisibility(View.VISIBLE);
//            Glide.with(ivTopic.getContext())
//                    .load(data.getBackground())
//                    .into(ivTopic);
//        }else {
//            ivTopic.setVisibility(View.GONE);
//        }
    }


    @Override
    public void onClick(View v) {

    }
}
