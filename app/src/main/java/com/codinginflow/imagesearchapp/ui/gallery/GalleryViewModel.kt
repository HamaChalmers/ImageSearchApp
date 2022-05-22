package com.codinginflow.imagesearchapp.ui.gallery

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import androidx.paging.cachedIn
import com.codinginflow.imagesearchapp.data.UnsplashRepository

class GalleryViewModel @ViewModelInject constructor( //ViewModels have their own unique @ (@ViewModelInject)
    private val repository: UnsplashRepository,
    @Assisted state: SavedStateHandle
) : ViewModel() {

    private val currentQuery = state.getLiveData(CURRENT_QUERY, DEFAULT_QUERY) //load the last query from save state (if no value will use default query)

    val photos = currentQuery.switchMap { queryString -> //switchMap updates whenever the current query changes
        repository.getSearchResults(queryString).cachedIn(viewModelScope) //search for photo with query picked
    }

    fun searchPhotos(query: String) { //change search request
        currentQuery.value = query
    }

    companion object {
        private const val CURRENT_QUERY= "current_query"
        private const val DEFAULT_QUERY = "cats"
    }
}