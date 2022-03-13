package com.example.dictionmaster.domain.model

import androidx.room.TypeConverters
import com.example.dictionmaster.data.local.Converters
import com.example.dictionmaster.data.remote.dto.ExampleXDto

data class Subsense(

    val definitions: List<String>,
    val examples: List<ExampleX>,
    val shortDefinitions: List<String>

)
