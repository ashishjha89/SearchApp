package com.ashishjha.searchapp.model;

import android.support.annotation.NonNull;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by ashish on 5/3/16.
 */
/*
* Sets correct repository for Prod Build Variant
*/
public class SearchListRepository {

    private SearchListRepository() {
    }

    private static SearchRepository repository = null;

    public synchronized static SearchRepository getProdRepoInstance(@NonNull SearchServiceApi searchListServiceApi) {
        checkNotNull(searchListServiceApi);
        if (null == repository) {
            repository = new SearchRepositoryImpl(searchListServiceApi);
        }
        return repository;
    }
}
