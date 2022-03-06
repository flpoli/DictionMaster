package com.example.dictionmaster.presentation.search

import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dictionmaster.data.remote.dto.WordDefinitionDto
import com.example.dictionmaster.domain.model.Language
import com.example.dictionmaster.repository.SearchRepository
import com.example.dictionmaster.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel
@Inject constructor(private val repository: SearchRepository) : ViewModel() {

    private val _word = mutableStateOf("")
    val word = _word

//    private var _searchState = mutableStateOf(SearchViewState())
//    var searchState: State<SearchViewState> = _searchState


    private var cachedSearch = listOf<WordDefinitionDto>()
    var lang by mutableStateOf(Language)
        private set

    fun onWordEnter(word: String) {
        _word.value = word
        println(word)
    }


//    fun onSearchClicked(lang: String, word: String) {
//
//        viewModelScope.launch(Dispatchers.IO) {
//
//            val response = repository.search(lang, word)
//            println("response? ${response.data}")
//            when(response){
//                is Resource.Success -> {
//                    _searchState.value = SearchViewState(response.data)
//                    println("In resource success ${_searchState.value }")
//                    println("SEARCHSTATE PUPLIC? ${searchState.value}")
//                }
//            }
//            return@launch
//
//        }
//    }

    fun onLangSelected(lang: String){

//        this.lang = Language(lang)
//        this.lang = Language.fromString(lang)
    }


}






