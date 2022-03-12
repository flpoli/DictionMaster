package com.example.dictionmaster.data.repository

import com.example.dictionmaster.data.local.WordInfoDao
import com.example.dictionmaster.data.remote.OxfordApi
import com.example.dictionmaster.domain.model.WordInfo
import com.example.dictionmaster.domain.repository.WordInfoRepository
import com.example.dictionmaster.util.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class WordInfoRepositoryImpl
    @Inject constructor(private val api: OxfordApi, private val dao: WordInfoDao): WordInfoRepository {



        override fun getWordInfo(word: String): Flow<Resource<List<WordInfo>>> {
            TODO("Not yet implemented")


        }
}