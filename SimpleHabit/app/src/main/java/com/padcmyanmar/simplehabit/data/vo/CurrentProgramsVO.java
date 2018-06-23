package com.padcmyanmar.simplehabit.data.vo;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;
import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import java.util.List;



/**
 * Created by eidoshack on 5/23/18.
 */
public class CurrentProgramsVO implements HomeScreenVO {

    @SerializedName("program-id")
    private String programId;

    private String title;

    @SerializedName("current-period")
    private String currentPeriod;

    private String background;

    @SerializedName("average-lengths")
    private int[] averageLength;

    private String description;

    private List<SessionsVO> sessions;

    public String getProgramId() {
        return programId;
    }

    public String getTitle() {
        return title;
    }

    public String getCurrentPeriod() {
        return currentPeriod;
    }

    public String getBackground() {
        return background;
    }

    public int[] getAverageLength() {
        return averageLength;
    }

    public String getDescription() {
        return description;
    }

    public List<SessionsVO> getSessions() {
        return sessions;
    }
}
