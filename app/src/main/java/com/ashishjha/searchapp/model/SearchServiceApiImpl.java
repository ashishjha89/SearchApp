package com.ashishjha.searchapp.model;

import android.support.annotation.NonNull;

import com.ashishjha.searchapp.tasks.CustomSearchTask;
import com.google.api.services.customsearch.model.Result;

import java.util.List;

/**
 * Created by ashish on 5/3/16.
 */
public class SearchServiceApiImpl implements SearchServiceApi {

    /*
    * load search results matching the query string
    */
    @Override
    public void getSearchResults(SearchQuery searchQuery, @NonNull final LoadSearchResultsCallback callback) {
        new CustomSearchTask(new TasksContract.LoadSearchResultsCallback() {
            @Override
            public void onResultsLoaded(List<Result> items) {
                callback.onResultsLoaded(items);
            }
        }).execute(searchQuery);
    }
}
