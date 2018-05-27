package com.padcmyanmar.simplehabit.events;

import java.util.List;

import com.padcmyanmar.simplehabit.data.vo.CategoriesVO;
import com.padcmyanmar.simplehabit.data.vo.CurrentProgramsVO;
import com.padcmyanmar.simplehabit.data.vo.TopicsVO;

/**
 * Created by eidoshack on 5/23/18.
 */

public class SimpleHabitEvents {

    public static class EmptyResponseEvent {

    }

    public static class ErrorInvokingAPIEvent {
        private String errorMsg;

        public ErrorInvokingAPIEvent(String errorMsg) {
            this.errorMsg = errorMsg;
        }

        public String getErrorMsg() {
            return errorMsg;
        }
    }

    public static class CurrentProgramsDataLoadedEvent {
        private CurrentProgramsVO loadCurrentPrograms;

        public CurrentProgramsDataLoadedEvent(CurrentProgramsVO loadCurrentPrograms) {
            this.loadCurrentPrograms = loadCurrentPrograms;
        }

        public CurrentProgramsVO getLoadCurrentPrograms() {
            return loadCurrentPrograms;
        }
    }

    public static class CategoriesDataLoadedEvent {
        private List<CategoriesVO> loadCategories;

        public CategoriesDataLoadedEvent(List<CategoriesVO> loadCategories) {
            this.loadCategories = loadCategories;
        }

        public List<CategoriesVO> getLoadCategories() {
            return loadCategories;
        }
    }

    public static class TopicsDataLoadedEvent {
        private List<TopicsVO> loadTopics;

        public TopicsDataLoadedEvent(List<TopicsVO> loadTopics) {
            this.loadTopics = loadTopics;
        }

        public List<TopicsVO> getLoadTopics() {
            return loadTopics;
        }
    }

}
