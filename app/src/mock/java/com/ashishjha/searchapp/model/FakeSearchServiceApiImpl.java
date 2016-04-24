package com.ashishjha.searchapp.model;

import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;

import com.google.api.services.customsearch.model.Result;

import java.util.List;

/**
 * Created by ashish on 5/3/16.
 */
public class FakeSearchServiceApiImpl implements SearchServiceApi {

    private static List<Result> ITEMS;

    @Override
    public void getSearchResults(SearchQuery searchQuery, @NonNull LoadSearchResultsCallback callback) {
        callback.onResultsLoaded(ITEMS);
    }

    @VisibleForTesting
    public static void setResultList(List<Result> items) {
        ITEMS = items;
    }
}
