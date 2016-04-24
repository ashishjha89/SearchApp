package com.ashishjha.searchapp.search;

import com.ashishjha.searchapp.R;
import com.ashishjha.searchapp.model.SearchQuery;
import com.ashishjha.searchapp.model.SearchRepository;
import com.google.api.services.customsearch.model.Result;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.mockito.Mockito.verify;

/**
 * Created by ashish on 5/3/16.
 */
public class SearchPresenterTest {

    private static SearchQuery IMAGE_SEARCH_QUERY = new SearchQuery("Batman", true, false, true);

    private static SearchQuery WEB_SEARCH_QUERY = new SearchQuery("Batman", true, false, false);

    @Mock
    private SearchRepository mSearchListRepository;

    @Mock
    private SearchContract.View mSearchListView;

    @Mock
    private List<Result> mResults;

    @Captor
    private ArgumentCaptor<SearchRepository.LoadSearchResultsCallback> mLoadResultsCallbackCaptor;

    @Captor
    private ArgumentCaptor<SearchQuery> mSearchQueryCaptor;

    private SearchPresenter mSearchPresenter;

    @Before
    public void setupCityPresenter() {
        MockitoAnnotations.initMocks(this);
        // Get a reference to the class under test
        mSearchPresenter = new SearchPresenter(mSearchListRepository, mSearchListView);
    }

    @Test
    public void loadImageResultsAndNotifyView() {
        // Given an initialized SearchPresenter
        mSearchPresenter.loadSearchResults(IMAGE_SEARCH_QUERY);

        // Verify progress dialog corresponding to Image Search is displaying
        verify(mSearchListView).setProgressIndicator(true, R.string.load_image_results);

        // Callback is captured and invoked with stubbed books
        verify(mSearchListRepository).getSearchResults(mSearchQueryCaptor.capture(), mLoadResultsCallbackCaptor.capture());
        mLoadResultsCallbackCaptor.getValue().onResultsLoaded(mResults);

        verify(mSearchListView).setResultItems(IMAGE_SEARCH_QUERY, mResults);
        // Then progress indicator is hidden and books are set in UI
        verify(mSearchListView).setProgressIndicator(false, -1);

    }

    @Test
    public void loadWebResultsAndNotifyView() {
        // Given an initialized SearchPresenter
        mSearchPresenter.loadSearchResults(WEB_SEARCH_QUERY);

        // Verify progress dialog corresponding to Image Search is displaying
        verify(mSearchListView).setProgressIndicator(true, R.string.load_web_results);

        // Callback is captured and invoked with stubbed books
        verify(mSearchListRepository).getSearchResults(mSearchQueryCaptor.capture(), mLoadResultsCallbackCaptor.capture());
        mLoadResultsCallbackCaptor.getValue().onResultsLoaded(mResults);

        verify(mSearchListView).setResultItems(WEB_SEARCH_QUERY, mResults);
        // Then progress indicator is hidden and books are set in UI
        verify(mSearchListView).setProgressIndicator(false, -1);

    }
}
