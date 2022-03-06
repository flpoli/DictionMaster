package com.example.dictionmaster.presentation.result

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dictionmaster.presentation.search.SearchViewState
import com.example.dictionmaster.repository.SearchRepository
import com.example.dictionmaster.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ResultScreenViewModel
    @Inject constructor(private val repository: SearchRepository): ViewModel() {

    private var _searchState = mutableStateOf(SearchViewState())
    var searchState: State<SearchViewState> = _searchState

        fun onSearchClicked(lang: String, word: String){

            viewModelScope.launch {

                val result = repository.search(lang, word)

                when(result){

                    is Resource.Success -> {
                        _searchState.value = SearchViewState(result.data)
                        //println(searchState.value)
                    }
                }
            }

        }

}