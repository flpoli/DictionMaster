package com.example.dictionmaster.presentation.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dictionmaster.data.remote.OxfordApi
import com.example.dictionmaster.repository.SearchRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel
    @Inject constructor(private val repository: SearchRepository): ViewModel() {




         fun onSearchClicked(lang: String, word: String){

             viewModelScope.launch(){
                 println("Lang: $lang")
                 println("Word: $word")


                 val response = repository.search(lang, word)



             }

             }


        }






