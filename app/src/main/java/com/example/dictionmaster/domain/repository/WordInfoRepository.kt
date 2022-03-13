package com.example.dictionmaster.domain.repository

import com.example.dictionmaster.data.remote.dto.WordInfoDto
import com.example.dictionmaster.domain.model.WordInfo
import com.example.dictionmaster.util.Resource
import kotlinx.coroutines.flow.Flow

interface WordInfoRepository {

    suspend fun getWordInfo(lang: String, word: String): Resource<WordInfoDto>
}