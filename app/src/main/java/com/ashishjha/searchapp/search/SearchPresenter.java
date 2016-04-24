package com.ashishjha.searchapp.search;

import android.support.annotation.NonNull;
import android.util.Log;

import com.ashishjha.searchapp.R;
import com.ashishjha.searchapp.model.SearchQuery;
import com.ashishjha.searchapp.model.SearchRepository;
import com.ashishjha.searchapp.util.ImageCaches;
import com.google.api.services.customsearch.model.Result;

import java.util.List;

/**
 * Created by ashish on 5/3/16.
 */
/*
* MVP Architecture is used for implementing Search list.
* This class forms the Presenter component of the architecture.
* It implements SearchContract.ActionsListener.
*
* The presenter sits between the model and view:
* it coordinates the UI with the data, ensuring they are in sync.
* Specifically, it updates the view and acts upon user events that are forwarded by the view.
* The presenter also retrieves data from the model, prepares it for display (by the view)
* and updates the model as necessary.
*/
public class SearchPresenter implements SearchContract.Presenter {

    private final SearchRepository mSearchListRepository;

    private final SearchContract.View mSearchListView;

    public SearchPresenter(@NonNull SearchRepository searchListRepository, @NonNull SearchContract.View searchListView) {
        mSearchListRepository = searchListRepository;
        mSearchListView = searchListView;
    }

    /*
    * load search results from Google Custom Search Engine
    */
    @Override
    public void loadSearchResults(final SearchQuery searchQuery) {
        if (searchQuery.isWithImage()) {
            mSearchListView.setProgressIndicator(true, R.string.load_image_results);
        } else {
            mSearchListView.setProgressIndicator(true, R.string.load_web_results);
        }
        mSearchListRepository.getSearchResults(searchQuery, new SearchRepository.LoadSearchResultsCallback() {
            @Override
            public void onResultsLoaded(List<Result> items) {
                mSearchListView.setResultItems(searchQuery, items);
                mSearchListView.setProgressIndicator(false, -1);
            }
        });
    }
}
