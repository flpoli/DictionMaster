package com.example.dictionmaster.domain.model

import androidx.room.TypeConverters
import com.example.dictionmaster.data.local.Converters
import com.example.dictionmaster.data.remote.dto.ExampleXDto

data class Subsense(

    val definitions: List<String> = emptyList(),
    val examples: List<ExampleX> = emptyList(),
    val shortDefinitions: List<String> = emptyList()

)
