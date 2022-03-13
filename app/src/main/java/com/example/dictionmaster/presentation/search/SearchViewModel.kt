package com.example.dictionmaster.presentation.search

import androidx.annotation.DrawableRes
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dictionmaster.R
import com.example.dictionmaster.domain.repository.WordInfoRepository
import com.example.dictionmaster.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
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

    private var _count = mutableStateOf(0)
    var countLimit = _count



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

    fun onSearchLimitReached(count: Int): Boolean{

        _count.value = count

        println("CONTAGEM: ${countLimit}}")
        return count >= 2

    }




}






