package com.example.dictionmaster.domain.model

import androidx.room.TypeConverters
import com.example.dictionmaster.data.local.Converters
import com.example.dictionmaster.data.remote.dto.ExampleDto
import com.example.dictionmaster.data.remote.dto.SubsenseDto

data class Sense (

    val definitions: List<String> = emptyList(),
    val examples: List<Example> = emptyList(),
    val shortDefinitions: List<String> = emptyList(),
    val subsenses: List<Subsense> = emptyList()

    )

