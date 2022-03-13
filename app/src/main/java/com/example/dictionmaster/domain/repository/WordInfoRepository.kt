package com.example.dictionmaster.domain.repository

import com.example.dictionmaster.data.remote.dto.WordInfoDto
import com.example.dictionmaster.util.Resource

interface WordInfoRepository {

    suspend fun getWordInfo(lang: String, word: String): Resource<WordInfoDto>
}