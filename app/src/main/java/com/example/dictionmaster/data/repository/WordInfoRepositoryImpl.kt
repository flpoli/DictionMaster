package com.example.dictionmaster.data.repository

import com.example.dictionmaster.R
import com.example.dictionmaster.data.local.WordInfoDao
import com.example.dictionmaster.data.local.entity.toWordInfo
import com.example.dictionmaster.data.remote.OxfordApi
import com.example.dictionmaster.data.remote.dto.toWordInfoEntity
//import com.example.dictionmaster.data.remote.dto.toWordInfoEntity
import com.example.dictionmaster.domain.model.WordInfo
import com.example.dictionmaster.domain.repository.WordInfoRepository
import com.example.dictionmaster.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject

class WordInfoRepositoryImpl(private val api: OxfordApi, private val dao: WordInfoDao): WordInfoRepository {



        override fun getWordInfo(lang: String, word: String): Flow<Resource<List<WordInfo>>> = flow {

            emit(Resource.Loading())

            val wordInfos = dao.getWordInfos(word).map {it.toWordInfo()}

            emit(Resource.Loading(data = wordInfos))

            try {

                val remoteWordInfos = api.getWordInfo(lang, word)
                dao.insertWordInfos(remoteWordInfos.map {it.toWordInfoEntity()})


            } catch (e: HttpException) {

                emit(Resource.Error(
                    message = "${R.string.on_http_error}",
                    data = wordInfos
                ))

            } catch (e: IOException) {

                emit(Resource.Error(
                    message = "${R.string.on_io_error}",
                    data = wordInfos
                ))
            }


            val newWordInfos = dao.getWordInfos(word).map {it.toWordInfo()}
            println("New INFO: $newWordInfos")
            emit(Resource.Success(data = newWordInfos))


        }
}