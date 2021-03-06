package com.padcmyanmar.simplehabit.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.padcmyanmar.simplehabit.R;
import com.padcmyanmar.simplehabit.data.vo.CategoriesVO;
import com.padcmyanmar.simplehabit.data.vo.CurrentProgramsVO;
import com.padcmyanmar.simplehabit.data.vo.HomeScreenVO;
import com.padcmyanmar.simplehabit.data.vo.TopicsVO;
import com.padcmyanmar.simplehabit.delegates.CategoryProgramDelegate;
import com.padcmyanmar.simplehabit.delegates.CurrentProgramDelegate;
import com.padcmyanmar.simplehabit.viewholders.BaseViewHolder;
import com.padcmyanmar.simplehabit.viewholders.CategoryViewHolder;
import com.padcmyanmar.simplehabit.viewholders.ItemInTopicViewHolder;
import com.padcmyanmar.simplehabit.viewholders.StartHereViewHolder;

public class SeriesAdapter extends BaseRecyclerAdapter<BaseViewHolder, HomeScreenVO> {

    private static final int START_HERE = 0;
    private static final int CATEGORY = 1;
    private static final int ALL_TOPICS = 2;

    private CurrentProgramDelegate mCurrentProgramDelegate;
    private CategoryProgramDelegate mCategoryProgramDelegate;

    public SeriesAdapter(Context context, CurrentProgramDelegate currentProgramDelegate,
                         CategoryProgramDelegate categoryProgramDelegate) {
        super(context);
        mCurrentProgramDelegate = currentProgramDelegate;
        mCategoryProgramDelegate = categoryProgramDelegate;
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        BaseViewHolder viewHolder = null;
        switch (viewType) {
            case START_HERE:
                viewHolder = new StartHereViewHolder(LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.layout_start_here, parent, false), mCurrentProgramDelegate);
                break;
            case CATEGORY:
                viewHolder = new CategoryViewHolder(LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.layout_healthy_mind, parent, false), mCategoryProgramDelegate);
                break;
            case ALL_TOPICS:
                viewHolder = new ItemInTopicViewHolder(LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.item_topic, parent, false));
                break;
        }

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
        holder.setData(mData.get(position));
    }


    @Override
    public int getItemViewType(int position) {
        if (mData.get(position) instanceof CurrentProgramsVO) {
            return START_HERE;
        } else if (mData.get(position) instanceof CategoriesVO) {
            return CATEGORY;
        } else if (mData.get(position) instanceof TopicsVO) {
            return ALL_TOPICS;
        }
        return position;
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

}
