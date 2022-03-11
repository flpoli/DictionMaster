package com.example.dictionmaster.domain.model

import com.example.dictionmaster.data.remote.dto.ExampleXDto

data class Subsense(

    val definitions: List<String>,
    val examples: List<ExampleXDto>,
    val shortDefinitions: List<String>

)
