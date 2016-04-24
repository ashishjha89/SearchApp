package com.ashishjha.searchapp.search;

import com.ashishjha.searchapp.model.SearchListRepository;
import com.ashishjha.searchapp.model.SearchRepository;
import com.ashishjha.searchapp.model.SearchServiceApiImpl;

/**
 * Created by ashish on 5/3/16.
 */
public class Injection {

    public static SearchRepository provideSearchRepository() {
        return SearchListRepository.getProdRepoInstance(new SearchServiceApiImpl());
    }

}