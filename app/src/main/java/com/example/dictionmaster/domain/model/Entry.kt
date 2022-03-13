package com.example.dictionmaster.domain.model

import androidx.room.TypeConverters
import com.example.dictionmaster.data.local.Converters
import com.example.dictionmaster.data.remote.dto.GrammaticalFeatureDto
import com.example.dictionmaster.data.remote.dto.PronunciationDto
import com.example.dictionmaster.data.remote.dto.SenseDto

data class Entry(

    val grammaticalFeatures: List<GrammaticalFeature> = emptyList(),
    val pronunciations: List<Pronunciation> = emptyList(),
    val senses: List<Sense> = emptyList()

)
