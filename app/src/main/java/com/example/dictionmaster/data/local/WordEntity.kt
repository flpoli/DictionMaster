package com.example.dictionmaster.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.dictionmaster.data.remote.dto.SenseDto
import com.example.dictionmaster.data.remote.dto.SubsenseDto

@Entity
data class WordEntity (

    @PrimaryKey
    val id: Int? = null,
    val word: String,
    val senses: List<SenseDto>,
    val subSenses: List<SubsenseDto>,
    val spellingIpa: String,
    val audioUrl: String,
)


