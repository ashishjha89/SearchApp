package com.ashishjha.searchapp.model;

import android.support.annotation.NonNull;

import com.google.api.services.customsearch.model.Result;

import java.util.List;

/**
 * Created by ashish on 5/3/16.
 */
public interface SearchServiceApi {

    /*
    * Callback to be invoked when search results are loaded
    */
    interface LoadSearchResultsCallback {
        void onResultsLoaded(List<Result> items);
    }

    /*
    * load search results matching the query string
    */
    void getSearchResults(SearchQuery searchQuery, @NonNull LoadSearchResultsCallback callback);
}
