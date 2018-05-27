package com.padcmyanmar.simplehabit.network;

/**
 * Created by eidoshack on 5/23/18.
 */

public interface SimpleHabitsDataAgent {

    void loadCurrentPrograms(String accessToken, int mmPageIndex);

    void loadCategories(String accessToken, int mmPageIndex);

    void loadTopics(String accessToken, int mmPageIndex);
}
