package com.padcmyanmar.simplehabit.data.vo;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by eidoshack on 5/23/18.
 */

public class CategoriesVO implements HomeScreenVO{

    @SerializedName("category-id")
    private String categoryId;
    private String title;
    private List<ProgramsVO> programs;

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<ProgramsVO> getPrograms() {
        return programs;
    }

    public void setPrograms(List<ProgramsVO> programs) {
        this.programs = programs;
    }
}
