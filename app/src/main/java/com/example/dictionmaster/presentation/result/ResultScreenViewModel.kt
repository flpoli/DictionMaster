package com.example.dictionmaster.presentation.result

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dictionmaster.domain.use_case.GetWordInfo
import com.example.dictionmaster.presentation.search.SearchViewState
import com.example.dictionmaster.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ResultScreenViewModel
    @Inject constructor(private val getWordInfo: GetWordInfo): ViewModel() {



    private val _state = mutableStateOf(SearchViewState())
    val state: State<SearchViewState> = _state

    private val _searchQuery = mutableStateOf("")
    val searchQuery: State<String> = _searchQuery

    private var _count = mutableStateOf(0)
    var countLimit = _count

    fun onSearch(lang: String, query: String){

        viewModelScope.launch(Dispatchers.IO) {

            val result = getWordInfo(lang, query)

                    when(result) {
                        is Resource.Success -> {
                            _state.value = SearchViewState(
                                wordInfoItems = result.data,
                                isLoading = false
                            )

                        }
                        is Resource.Error -> {

                            _state.value = SearchViewState(
                                wordInfoItems = result.data,
                                isLoading = false
                            )

                        }
                        is Resource.Loading ->  {
                            _state.value = SearchViewState(
                                wordInfoItems = result.data,
                                isLoading = true
                            )
                        }

                    }
                }
        }

    fun onSearchLimitReached(limit: Int): Boolean {

        return limit >= 10
    }
    }
