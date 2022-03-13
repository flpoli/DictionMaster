package com.example.dictionmaster.domain.use_case

import com.example.dictionmaster.data.remote.dto.WordInfoDto
import com.example.dictionmaster.domain.repository.WordInfoRepository
import com.example.dictionmaster.util.Resource

class GetWordInfo(private val repository: WordInfoRepository) {


        suspend operator fun invoke(lang: String, word: String): Resource<WordInfoDto> {

            return repository.getWordInfo(lang, word)
        }

}