package com.padcmyanmar.simplehabit.mvp.presenters;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import com.padcmyanmar.simplehabit.data.models.SimpleHabitsModel;
import com.padcmyanmar.simplehabit.delegates.CategoryProgramDelegate;
import com.padcmyanmar.simplehabit.delegates.CurrentProgramDelegate;
import com.padcmyanmar.simplehabit.events.NetworkErrorEvent;
import com.padcmyanmar.simplehabit.events.SuccessEvent;
import com.padcmyanmar.simplehabit.mvp.views.HomeScreenView;

public class HomeScreenPresenter extends BasePresenter<HomeScreenView> implements CurrentProgramDelegate
    ,CategoryProgramDelegate{
    public HomeScreenPresenter(HomeScreenView mView) {
        super(mView);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        SimpleHabitsModel.getInstance().startLoadingSimpleHabits();
    }

    @Override
    public void onStart() {
        super.onStart();
        if(!EventBus.getDefault().isRegistered(this))
            EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        if(EventBus.getDefault().isRegistered(this))
            EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onDataLoaded(SuccessEvent event){
        if (event != null){
            mView.displayHomeScreen(event.getmData());
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onDataLoadedError(NetworkErrorEvent event){
        mView.dispalyErrorMessage(event.getErrorMsg());
    }

    @Override
    public void onTapCategoryProgramDelegate(String categoryId, String categoryProgramId) {
        mView.lunchDetail(categoryId,categoryProgramId);
    }

    @Override
    public void onTapCurrentProgram() {
        mView.lunchDetail();
    }
}
