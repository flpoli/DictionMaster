package com.example.dictionmaster.domain.repository

import com.example.dictionmaster.domain.model.WordInfo
import com.example.dictionmaster.util.Resource
import kotlinx.coroutines.flow.Flow

interface WordInfoRepository {

    fun getWordInfo(lang: String, word: String): Flow<Resource<WordInfo>>
}