package com.example.dictionmaster.presentation.search

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.dictionmaster.domain.repository.WordInfoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SearchViewModel
@Inject constructor(private val repository: WordInfoRepository) : ViewModel() {

    private val _word = mutableStateOf("")
    val word = _word

    private val _lang = mutableStateOf("ENGLISH")
    val lang = _lang

    private val _langCode = mutableStateOf("en-gb")
    val langCode = _langCode

    fun onWordEnter(word: String) {
            _word.value = word
    }

    fun onLangSelected(lang: String){
        _lang.value = lang

        when(_lang.value) {

            "ENGLISH" -> _langCode.value = "en-gb"
            "SPANISH" -> _langCode.value = "es"
            "FRENCH" -> _langCode.value = "fr"
        }
    }

}






