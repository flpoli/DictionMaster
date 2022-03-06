package com.example.dictionmaster.presentation.search

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dictionmaster.domain.model.Language
import com.example.dictionmaster.repository.SearchRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel
@Inject constructor(private val repository: SearchRepository) : ViewModel() {

    private val _word = mutableStateOf("")
    val word = _word


    var lang by mutableStateOf(Language)
        private set

    fun onWordEnter(word: String) {
        _word.value = word
        println(word)
    }


    fun onSearchClicked(lang: String, word: String) {

        viewModelScope.launch {


            val response = repository.search(lang, word)
            println("Response: ${response}")


        }

    }

    fun onLangSelected(lang: String){

//        this.lang = Language(lang)
//        this.lang = Language.fromString(lang)
    }


}






