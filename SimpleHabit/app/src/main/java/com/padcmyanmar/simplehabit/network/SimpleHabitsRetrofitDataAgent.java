package com.padcmyanmar.simplehabit.network;

import com.google.gson.Gson;

import org.greenrobot.eventbus.EventBus;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import com.padcmyanmar.simplehabit.events.SimpleHabitEvents;
import com.padcmyanmar.simplehabit.network.responses.GetCategoriesResponse;
import com.padcmyanmar.simplehabit.network.responses.GetCurrentProgramsResponse;
import com.padcmyanmar.simplehabit.network.responses.GetTopicResponse;

/**
 * Created by eidoshack on 5/23/18.
 */

public class SimpleHabitsRetrofitDataAgent implements SimpleHabitsDataAgent {

    private static SimpleHabitsRetrofitDataAgent objInstance;

    private SimpleHabitsAPI theAPI;

    private SimpleHabitsRetrofitDataAgent() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://padcmyanmar.com/padc-5/simple-habits/")
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .client(okHttpClient)
                .build();

        theAPI = retrofit.create(SimpleHabitsAPI.class);

    }

    public static SimpleHabitsRetrofitDataAgent getInstance() {
        if (objInstance == null) {
            objInstance = new SimpleHabitsRetrofitDataAgent();
        }
        return objInstance;
    }

    @Override
    public void loadCurrentPrograms(String accessToken, int mmPageIndex) {
        Call<GetCurrentProgramsResponse> loadCurrentProgramsCall = theAPI.loadCurrentPrograms(1,"b002c7e1a528b7cb460933fc2875e916");
        loadCurrentProgramsCall.enqueue(new Callback<GetCurrentProgramsResponse>() {
            @Override
            public void onResponse(Call<GetCurrentProgramsResponse> call, Response<GetCurrentProgramsResponse> response) {
                GetCurrentProgramsResponse getCurrentProgramsResponse = response.body();
                if (getCurrentProgramsResponse != null
                        && getCurrentProgramsResponse.getCurrentProgram() != null) {
                    SimpleHabitEvents.CurrentProgramsDataLoadedEvent currentProgramsDataLoadedEvent = new SimpleHabitEvents.CurrentProgramsDataLoadedEvent(
                            getCurrentProgramsResponse.getCurrentProgram());
                    EventBus.getDefault().post(currentProgramsDataLoadedEvent);
                } else {
                    SimpleHabitEvents.ErrorInvokingAPIEvent errorEvent
                            = new SimpleHabitEvents.ErrorInvokingAPIEvent("Can't Load . Try Again");
                    EventBus.getDefault().post(errorEvent);
                }
            }

            @Override
            public void onFailure(Call<GetCurrentProgramsResponse> call, Throwable t) {
                SimpleHabitEvents.ErrorInvokingAPIEvent errorInvokingAPIEvent = new SimpleHabitEvents.ErrorInvokingAPIEvent(t.getMessage());
                EventBus.getDefault().post(errorInvokingAPIEvent);
            }
        });
    }

    @Override
    public void loadCategories(String accessToken, int mmPageIndex) {
        Call<GetCategoriesResponse> loadCategoriesCall = theAPI.loadCategories(1, "b002c7e1a528b7cb460933fc2875e916");
        loadCategoriesCall.enqueue(new Callback<GetCategoriesResponse>() {
            @Override
            public void onResponse(Call<GetCategoriesResponse> call, Response<GetCategoriesResponse> response) {
                GetCategoriesResponse getCategoriesResponse = response.body();
                if (getCategoriesResponse != null
                        && getCategoriesResponse.getCategoriesPrograms().size() > 0) {
                    SimpleHabitEvents.CategoriesDataLoadedEvent categoriesDataLoadedEvent = new SimpleHabitEvents.CategoriesDataLoadedEvent(
                            getCategoriesResponse.getCategoriesPrograms());
                    EventBus.getDefault().post(categoriesDataLoadedEvent);
                } else {
                    SimpleHabitEvents.ErrorInvokingAPIEvent errorEvent
                            = new SimpleHabitEvents.ErrorInvokingAPIEvent("Can't Load . Try Again");
                    EventBus.getDefault().post(errorEvent);
                }
            }

            @Override
            public void onFailure(Call<GetCategoriesResponse> call, Throwable t) {
                SimpleHabitEvents.ErrorInvokingAPIEvent errorInvokingAPIEvent = new SimpleHabitEvents.ErrorInvokingAPIEvent(t.getMessage());
                EventBus.getDefault().post(errorInvokingAPIEvent);
            }
        });
    }

    @Override
    public void loadTopics(String accessToken, int mmPageIndex) {
        Call<GetTopicResponse> loadTopicsCall = theAPI.loadTopics(1, "b002c7e1a528b7cb460933fc2875e916");
        loadTopicsCall.enqueue(new Callback<GetTopicResponse>() {
            @Override
            public void onResponse(Call<GetTopicResponse> call, Response<GetTopicResponse> response) {
                GetTopicResponse getTopicResponse = response.body();
                if (getTopicResponse != null
                        && getTopicResponse.getTopics().size() > 0) {
                    SimpleHabitEvents.TopicsDataLoadedEvent topicsDataLoadedEvent = new SimpleHabitEvents.TopicsDataLoadedEvent(
                            getTopicResponse.getTopics());
                    EventBus.getDefault().post(topicsDataLoadedEvent);
                } else {
                    SimpleHabitEvents.ErrorInvokingAPIEvent errorEvent
                            = new SimpleHabitEvents.ErrorInvokingAPIEvent("Can't Load . Try Again");
                    EventBus.getDefault().post(errorEvent);
                }
            }

            @Override
            public void onFailure(Call<GetTopicResponse> call, Throwable t) {
                SimpleHabitEvents.ErrorInvokingAPIEvent errorInvokingAPIEvent = new SimpleHabitEvents.ErrorInvokingAPIEvent(t.getMessage());
                EventBus.getDefault().post(errorInvokingAPIEvent);
            }
        });
    }
}
