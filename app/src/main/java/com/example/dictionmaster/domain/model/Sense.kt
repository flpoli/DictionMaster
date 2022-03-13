package com.example.dictionmaster.domain.model

import androidx.room.TypeConverters
import com.example.dictionmaster.data.local.Converters
import com.example.dictionmaster.data.remote.dto.ExampleDto
import com.example.dictionmaster.data.remote.dto.SubsenseDto

data class Sense (

    val definitions: List<String>,
    val examples: List<Example>,
    val shortDefinitions: List<String>,
    val subsenses: List<Subsense>

    )

