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
public class ProgramsVO {
    @SerializedName("program-id")
    private String programId;

    private String title;

    private String image;

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

    public String getImage() {
        return image;
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
