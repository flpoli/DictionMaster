package com.example.dictionmaster.domain.model

import androidx.room.TypeConverters
import com.example.dictionmaster.data.local.Converters
import com.example.dictionmaster.data.remote.dto.GrammaticalFeatureDto
import com.example.dictionmaster.data.remote.dto.PronunciationDto
import com.example.dictionmaster.data.remote.dto.SenseDto

data class Entry(

    val grammaticalFeatures: List<GrammaticalFeature>,
    val pronunciations: List<Pronunciation>,
    val senses: List<Sense>

)
