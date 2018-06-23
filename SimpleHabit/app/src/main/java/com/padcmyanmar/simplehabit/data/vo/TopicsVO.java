package com.padcmyanmar.simplehabit.data.vo;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

/**
 * Created by eidoshack on 5/23/18.
 */
public class TopicsVO implements HomeScreenVO {

    @SerializedName("topic-name")
    private String topicName;

    @SerializedName("topic-desc")
    private String topicDesc;

    private String icon;

    private String background;

    public String getTopicName() {
        return topicName;
    }

    public String getTopicDesc() {
        return topicDesc;
    }

    public String getIcon() {
        return icon;
    }

    public String getBackground() {
        return background;
    }
}
