package com.example.dictionmaster.domain.model

import com.example.dictionmaster.data.remote.dto.GrammaticalFeatureDto
import com.example.dictionmaster.data.remote.dto.PronunciationDto
import com.example.dictionmaster.data.remote.dto.SenseDto

data class Entry(

    val grammaticalFeatures: List<GrammaticalFeatureDto>,
    val pronunciations: List<PronunciationDto>,
    val senses: List<SenseDto>

)
