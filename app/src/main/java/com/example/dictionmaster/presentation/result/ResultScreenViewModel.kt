package com.example.dictionmaster.presentation.result

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dictionmaster.domain.repository.WordInfoRepository
import com.example.dictionmaster.presentation.search.SearchViewState
import com.example.dictionmaster.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ResultScreenViewModel
    @Inject constructor(private val repository: WordInfoRepository): ViewModel() {



    private val _state = mutableStateOf(SearchViewState())
    val state: State<SearchViewState> = _state



    fun onSearch(lang: String, query: String){
        viewModelScope.launch {

            delay(500L)

            repository.getWordInfo(lang, query)
                .onEach { result ->
                    when(result) {
                        is Resource.Success -> {

                            _state.value = state.value.copy(
                                wordInfo = result.data,
                                isLoading = false
                            )
                        }

                        is Resource.Error -> {

                            _state.value = state.value.copy(
                                wordInfo = result.data,
                                isLoading = false
                            )

                        }

                        is Resource.Loading ->  {
                            _state.value = state.value.copy(
                                wordInfo = result.data,
                                isLoading = true
                            )
                        }

                    }
                }.launchIn(this)

        }

    }



}