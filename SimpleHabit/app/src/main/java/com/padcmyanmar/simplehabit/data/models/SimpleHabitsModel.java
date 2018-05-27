package com.padcmyanmar.simplehabit.data.models;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

import com.padcmyanmar.simplehabit.data.vo.CategoriesVO;
import com.padcmyanmar.simplehabit.data.vo.CurrentProgramsVO;
import com.padcmyanmar.simplehabit.data.vo.HomeScreenVO;
import com.padcmyanmar.simplehabit.data.vo.TopicsVO;
import com.padcmyanmar.simplehabit.events.SimpleHabitEvents;
import com.padcmyanmar.simplehabit.events.SuccessEvent;
import com.padcmyanmar.simplehabit.network.SimpleHabitsRetrofitDataAgent;
import com.padcmyanmar.simplehabit.utils.AppConstants;

/**
 * Created by eidoshack on 5/23/18.
 */

public class SimpleHabitsModel {

    private static SimpleHabitsModel objInstance;

    private List<HomeScreenVO> currentList;
    private int mmPageIndex = 1;

    private SimpleHabitsModel() {
        EventBus.getDefault().register(this);
        currentList = new ArrayList<>();
    }

    public static SimpleHabitsModel getInstance() {
        if(objInstance == null) {
            objInstance = new SimpleHabitsModel();
        }
        return objInstance;
    }

    public void     startLoadingSimpleHabits() {
        SimpleHabitsRetrofitDataAgent.getInstance().loadCurrentPrograms(AppConstants.ACCESS_TOKEN, mmPageIndex);
    }

    @Subscribe
    public void onCurrentProgramDataLoaded(SimpleHabitEvents.CurrentProgramsDataLoadedEvent event) {
        currentList.add(event.getLoadCurrentPrograms());
        SimpleHabitsRetrofitDataAgent.getInstance().loadCategories(AppConstants.ACCESS_TOKEN, mmPageIndex);
    }

    @Subscribe
    public void onCategoriesDataLoaded(SimpleHabitEvents.CategoriesDataLoadedEvent event) {
        currentList.addAll(event.getLoadCategories());
        SimpleHabitsRetrofitDataAgent.getInstance().loadTopics(AppConstants.ACCESS_TOKEN, mmPageIndex);
    }

    @Subscribe
    public void onTopicsDataLoaded(SimpleHabitEvents.TopicsDataLoadedEvent event) {
        currentList.addAll(event.getLoadTopics());
        SuccessEvent dataReadyEvent = new SuccessEvent(currentList);
        EventBus.getDefault().post(dataReadyEvent);
    }



}
