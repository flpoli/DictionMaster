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

    private val _lang = mutableStateOf("")
    val lang = _lang

    private var cachedSearch = listOf<WordDefinitionDto>()


    fun onWordEnter(word: String) {
        _word.value = word
        println(word)
    }

    fun onLangSelected(lang: String){
        _lang.value = lang
        println("lang: $lang")
    }


}






