package com.example.dictionmaster.domain.use_case

import com.example.dictionmaster.domain.model.WordInfo
import com.example.dictionmaster.domain.repository.WordInfoRepository
import com.example.dictionmaster.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetWordInfo(private val repository: WordInfoRepository) {


        operator fun invoke(lang: String, word: String): Flow<Resource<WordInfo>> {

            if(word.isBlank()){
                return flow { }
            }

            return repository.getWordInfo(lang, word)
        }

}