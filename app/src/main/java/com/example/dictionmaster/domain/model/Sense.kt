package com.example.dictionmaster.domain.model

import com.example.dictionmaster.data.remote.dto.ExampleDto
import com.example.dictionmaster.data.remote.dto.SubsenseDto

data class Sense (

    val definitions: List<String>,
    val examples: List<ExampleDto>,
    val shortDefinitions: List<String>,
    val subsenses: List<SubsenseDto>

    )

