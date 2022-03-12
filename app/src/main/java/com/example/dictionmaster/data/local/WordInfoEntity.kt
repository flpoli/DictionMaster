package com.example.dictionmaster.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.dictionmaster.data.remote.dto.SenseDto
import com.example.dictionmaster.data.remote.dto.SubsenseDto
import com.example.dictionmaster.domain.model.Sense
import com.example.dictionmaster.domain.model.Subsense
import com.example.dictionmaster.domain.model.Result
@Entity
data class WordInfoEntity (

    @PrimaryKey
    val id: Int? = null,
    val word: String,

    // deveria ser ...:

    val results: List<Result>

)


