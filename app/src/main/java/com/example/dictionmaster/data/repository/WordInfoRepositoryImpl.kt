package com.example.dictionmaster.data.repository

import com.example.dictionmaster.data.remote.OxfordApi
import com.example.dictionmaster.data.remote.dto.WordInfoDto
import com.example.dictionmaster.domain.repository.WordInfoRepository
import com.example.dictionmaster.util.Resource

class WordInfoRepositoryImpl(private val api: OxfordApi): WordInfoRepository {

        override suspend fun getWordInfo(lang: String, word: String): Resource<WordInfoDto> {

            val remoteInfo = api.getWordInfo(lang, word)

            return Resource.Success(remoteInfo)

        }
}