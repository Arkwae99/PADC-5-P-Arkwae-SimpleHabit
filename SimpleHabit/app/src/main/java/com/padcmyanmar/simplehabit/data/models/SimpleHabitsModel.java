package com.padcmyanmar.simplehabit.data.models;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import com.padcmyanmar.simplehabit.data.vo.CategoriesVO;
import com.padcmyanmar.simplehabit.data.vo.CurrentProgramsVO;
import com.padcmyanmar.simplehabit.data.vo.HomeScreenVO;
import com.padcmyanmar.simplehabit.data.vo.ProgramsVO;
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

    private List<HomeScreenVO> seriesData;
    private int mmPageIndex = 1;

    private SimpleHabitsModel() {

        seriesData = new ArrayList<>();
        EventBus.getDefault().register(this);
    }

    public static SimpleHabitsModel getInstance() {
        if(objInstance == null) {
            objInstance = new SimpleHabitsModel();
        }
        return objInstance;
    }

    public List<HomeScreenVO> getSeriesData() {
        return seriesData;
    }

    public CurrentProgramsVO getCurrentProgram(){
        for(HomeScreenVO obj:seriesData){
            if(obj instanceof CurrentProgramsVO)
                return (CurrentProgramsVO)obj;
        }
        return null;
    }

    public ProgramsVO getProgram(String categoryId, String categoryProgramId){
        for(int i=0; i<seriesData.size(); i++){
            if(seriesData.get(i) instanceof CategoriesVO){
                if(((CategoriesVO) seriesData.get(i)).getCategoryId().equals(categoryId)){
                    for(int j = 0; j < ((CategoriesVO) seriesData.get(i)).getPrograms().size(); j++){
                        if(((CategoriesVO) seriesData.get(i)).getPrograms().get(j).getProgramId().equals(categoryProgramId)){
                            return ((CategoriesVO) seriesData.get(i)).getPrograms().get(j);
                        }
                    }
                }
            }
        }
        return null;
    }

    public void startLoadingSimpleHabits() {
        SimpleHabitsRetrofitDataAgent.getInstance().loadCurrentPrograms(AppConstants.ACCESS_TOKEN, mmPageIndex);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onCurrentProgramDataLoaded(SimpleHabitEvents.CurrentProgramsDataLoadedEvent event) {
        seriesData.add(event.getLoadCurrentPrograms());
        SimpleHabitsRetrofitDataAgent.getInstance().loadCategories(AppConstants.ACCESS_TOKEN, mmPageIndex);
    }

    @Subscribe
    public void onCategoriesDataLoaded(SimpleHabitEvents.CategoriesDataLoadedEvent event) {
        seriesData.addAll(event.getLoadCategories());
        SimpleHabitsRetrofitDataAgent.getInstance().loadTopics(AppConstants.ACCESS_TOKEN, mmPageIndex);
    }

    @Subscribe
    public void onTopicsDataLoaded(SimpleHabitEvents.TopicsDataLoadedEvent event) {
        seriesData.addAll(event.getLoadTopics());
        SuccessEvent dataReadyEvent = new SuccessEvent(seriesData);
        EventBus.getDefault().post(dataReadyEvent);
    }



}
