package com.padcmyanmar.simplehabit;

import android.app.Application;

import com.padcmyanmar.simplehabit.data.models.SimpleHabitsModel;

/**
 * Created by Ag Phone Khant on 26/5/2018.
 */

public class SimpleHabitApp extends Application {
    public static final String LOG_TAG = "SimpleHabit";
    public static final String PROGRAM_ID = "ProgramId";
    public static final String VIEW_TYPE = "viewType";
    public static final String CURRENT_PROGRAM = "currentProgram";
    public static final String CATEGORY = "category";
    public static final String CATEGORY_ID = "categoryId";
    public static final String CATEGORY_PROGRAM_ID = "categoryProgramId";



    @Override
    public void onCreate() {
        super.onCreate();
    }
}
