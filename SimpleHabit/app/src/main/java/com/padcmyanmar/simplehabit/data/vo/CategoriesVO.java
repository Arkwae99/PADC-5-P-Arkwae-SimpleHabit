package com.padcmyanmar.simplehabit.data.vo;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by eidoshack on 5/23/18.
 */
@Entity(tableName = "Categories")
public class CategoriesVO implements HomeScreenVO {

    @SerializedName("category-id")
    private String categoryId;

    private String title;

    private List<ProgramsVO> programs;

    public String getCategoryId() {
        return categoryId;
    }

    public String getTitle() {
        return title;
    }

    public List<ProgramsVO> getPrograms() {
        return programs;
    }
}
