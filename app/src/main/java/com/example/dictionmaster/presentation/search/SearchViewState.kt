package com.example.dictionmaster.presentation.search

import com.example.dictionmaster.data.remote.dto.WordDefinitionDto

data class SearchViewState (
    val searchResult: WordDefinitionDto? = null
)