package com.padcmyanmar.simplehabit.events;

import com.padcmyanmar.simplehabit.data.vo.HomeScreenVO;

import java.util.List;

/**
 * Created by Ag Phone Khant on 26/5/2018.
 */

public class SuccessEvent {
    private List<HomeScreenVO> mData;

    public SuccessEvent(List<HomeScreenVO> data){
        this.mData = data;
    }
    public List<HomeScreenVO> getmData(){
        return mData;
    }
}

