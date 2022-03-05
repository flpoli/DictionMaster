package com.example.dictionmaster.repository

import com.example.dictionmaster.data.remote.OxfordApi
import com.example.dictionmaster.data.remote.dto.Result
import com.example.dictionmaster.data.remote.dto.WordDefinitionDto
import com.example.dictionmaster.util.Resource
import javax.inject.Inject

class SearchRepository @Inject constructor(private val api: OxfordApi) {

     suspend fun search(lang: String, word: String): Resource<WordDefinitionDto> {

        val response = try {

            api.searchWord(lang, word)

        } catch (e: Exception) {

            return Resource.Error("An error occurred:\n $e")
        }

        return Resource.Success(response)

    }
}