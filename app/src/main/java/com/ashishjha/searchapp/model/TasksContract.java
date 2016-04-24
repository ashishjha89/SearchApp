package com.ashishjha.searchapp.model;

import com.google.api.services.customsearch.model.Result;

import java.util.List;

/**
 * Created by ashish on 5/3/16.
 */
public interface TasksContract {

    interface LoadSearchResultsCallback {
        void onResultsLoaded(List<Result> items);
    }
}
