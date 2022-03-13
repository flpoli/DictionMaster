package com.example.dictionmaster.data.repository

import androidx.compose.material.MaterialTheme.typography
import com.example.dictionmaster.R
import com.example.dictionmaster.data.remote.OxfordApi
import com.example.dictionmaster.data.remote.dto.WordInfoDto
import com.example.dictionmaster.data.remote.dto.toWordInfo
import com.example.dictionmaster.domain.model.WordInfo
import com.example.dictionmaster.domain.repository.WordInfoRepository
import com.example.dictionmaster.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException

class WordInfoRepositoryImpl(private val api: OxfordApi): WordInfoRepository {



        override fun getWordInfo(lang: String, word: String): Flow<Resource<WordInfoDto>> = flow {

            val remoteInfo = api.getWordInfo(lang, word)
            emit(Resource.Loading())
            try{
                Resource.Loading(remoteInfo)

                emit(Resource.Success(remoteInfo))
            }catch(e: HttpException){

                Resource.Error(message = "${R.string.on_http_error}", remoteInfo)

            }
        }
}