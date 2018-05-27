package com.padcmyanmar.simplehabit.data.vo;

import com.google.gson.annotations.SerializedName;

/**
 * Created by eidoshack on 5/23/18.
 */

public class SessionsVO  {

    @SerializedName("session-id")
    private String sessionId;
    private String title;
    @SerializedName("length-in-seconds")
    private int lengthInSeconds;
    @SerializedName("file-path")
    private String filePath;

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getLengthInSeconds() {
        return lengthInSeconds;
    }

    public void setLengthInSeconds(int lengthInSeconds) {
        this.lengthInSeconds = lengthInSeconds;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
