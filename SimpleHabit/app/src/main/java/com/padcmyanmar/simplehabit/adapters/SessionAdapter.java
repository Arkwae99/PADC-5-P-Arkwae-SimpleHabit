package com.padcmyanmar.simplehabit.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.padcmyanmar.simplehabit.R;
import com.padcmyanmar.simplehabit.data.vo.SessionsVO;
import com.padcmyanmar.simplehabit.viewholders.SessionViewHolder;

/**
 * Created by Ag Phone Khant on 2/6/2018.
 */

public class SessionAdapter extends BaseRecyclerAdapter<SessionViewHolder, SessionsVO> {

    public SessionAdapter(Context context) {
        super(context);
    }


    @NonNull
    @Override
    public SessionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mLayoutInflator.inflate(R.layout.item_detail, parent, false);
        return new SessionViewHolder(view);
    }

}
